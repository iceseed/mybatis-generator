//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.maven.plugins.mybatis.utils;

import com.maven.plugins.mybatis.core.Column;
import com.maven.plugins.mybatis.core.Context;
import com.maven.plugins.mybatis.core.DTO;
import com.maven.plugins.mybatis.core.PrimariKey;
import com.maven.plugins.mybatis.core.Table;
import com.maven.plugins.mybatis.core.Vo;
import com.maven.plugins.mybatis.generator.DTOGenerator;
import com.maven.plugins.mybatis.generator.DomainGenerator;
import com.maven.plugins.mybatis.generator.MapperGenerator;
import com.maven.plugins.mybatis.generator.ServiceGenerator;
import com.maven.plugins.mybatis.generator.SqlMapGenerator;
import com.maven.plugins.mybatis.generator.VoGenerator;
import java.io.File;
import java.util.*;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GeneratorUtils {
    private static Context context = null;

    public GeneratorUtils() {
    }

    public static void main(String[] args) throws Exception {
        runner(args[0], args[1], args[2], args[3]);
    }

    public static void runner(String mapper, String sqlmap, String vo, String configDirectory) throws Exception {
        initContext(mapper, sqlmap, vo, configDirectory);
        FreemarkerUtils.processBefore();
        Iterator var4 = context.getTables().iterator();

        while(true) {
            while(var4.hasNext()) {
                Table table = (Table)var4.next();
                if (table.getPrimaryKey() != null && table.getPrimaryKey().getJdbcType() != null) {
                    DomainGenerator.process(context, table);
                    MapperGenerator.process(context, table);
                    ServiceGenerator.process(context, table);
                    SqlMapGenerator.process(context, table);
                    VoGenerator.process(context, table);
                    DTOGenerator.process(context, table);
                } else {
                    System.out.println("表`" + table.getTableName() + "`,没有找到主键，跳过处理！");
                }
            }

            FreemarkerUtils.processEnd();
            System.out.println("========bye bye!=========");
            return;
        }
    }

    public static void initContext(String mapper, String sqlmap, String vo, String configDirectory) throws Exception {
        if (!StringUtils.isBlank(mapper) && !StringUtils.isBlank(sqlmap) && !StringUtils.isBlank(vo) && !StringUtils.isBlank(configDirectory)) {
            File config = new File(configDirectory);
            if (!config.exists()) {
                throw new Exception("没有找到配置文件：" + configDirectory);
            } else {
                SAXReader reader = new SAXReader();
                Document document = reader.read(config);
                Element root = document.getRootElement();
                context = new Context();
                context.setSchema(root.attributeValue("schema"));
                jdbcConection(root, context);
                javaTypeResolver(root, context);
                extendsBase(root,context);
                importClasses(root,context);
                context.setMapper(mapper);
                context.setVo(vo);
                context.setSqlmap(sqlmap);
                parseTables(root, context);
                setColumns(context);
            }
        } else {
            throw new Exception("参数异常");
        }
    }

    public static void setColumns(Context ctx) throws Exception {
        Iterator i$ = ctx.getTables().iterator();

        while(i$.hasNext()) {
            Table table = (Table)i$.next();
            List<Column> columns = DbUtils.getColumns(ctx, table.getTableName());
            table.setColumns(columns);

            Iterator var4 = columns.iterator();

            while(var4.hasNext()) {
                Column column = (Column)var4.next();
                column.setPropertyName(JavaBeanUtils.getCamelCaseString(column.getName(), false));
                column.setJdbcType(ctx.getJavaTypeResolver().getProperty(column.getDataType()));
                if (table.getColumnOverids() != null) {
                    String jdbcType = table.getColumnOverids().getProperty(column.getDataType(), ctx.getJavaTypeResolver().getProperty(column.getDataType()));
                    if (jdbcType == null || "".equals(jdbcType)) {
                        jdbcType = "Object";
                    }

                    column.setJdbcType(jdbcType);
                }

                if (table.getPrimaryKey() != null && column.getName().equals(table.getPrimaryKey().getColumnName())) {
                    table.getPrimaryKey().setJdbcType(column.getJdbcType());
                    table.getPrimaryKey().setPropertyName(column.getPropertyName());
                    column.setPrimaryKey(true);
                }
            }
        }

    }

    public static void jdbcConection(Element root, Context ctx) throws Exception {
        Element jdbcConection = root.element("jdbcConnection");
        if (jdbcConection == null) {
            throw new Exception("没有找到jdbcConection节点");
        } else {
            String driverClass = jdbcConection.attributeValue("driverClass");
            if (driverClass == null) {
                throw new Exception("没有找到jdbcConection节点的driverClass属性或为空");
            } else {
                String connectionURL = jdbcConection.attributeValue("connectionURL");
                if (connectionURL == null) {
                    throw new Exception("没有找到jdbcConection节点的connectionURL属性或为空");
                } else {
                    String uName = jdbcConection.attributeValue("uName");
                    if (uName == null) {
                        throw new Exception("没有找到jdbcConection节点的uName属性或为空");
                    } else {
                        String password = jdbcConection.attributeValue("password");
                        if (password == null) {
                            throw new Exception("没有找到jdbcConection节点的password属性或为空");
                        } else {
                            Properties properties = new Properties();
                            properties.put("driverClass", driverClass);
                            properties.put("connectionURL", connectionURL);
                            properties.put("uName", uName);
                            properties.put("password", password);
                            ctx.setJdbcProperties(properties);
                        }
                    }
                }
            }
        }
    }

    public static void javaTypeResolver(Element root, Context ctx) throws Exception {
        List nodes = root.selectNodes("//context/javaTypeResolver/property");
        Properties properties = new Properties();
        Iterator i$ = nodes.iterator();

        while(i$.hasNext()) {
            Object object = i$.next();
            Element property = (Element)object;
            properties.put(property.attributeValue("name"), property.attributeValue("value"));
        }

        ctx.setJavaTypeResolver(properties);
    }

    public static void extendsBase(Element root, Context ctx) throws Exception {
        List nodes = root.selectNodes("//context/extendsBase/property");
        Properties properties = new Properties();
        Iterator i$ = nodes.iterator();

        while(i$.hasNext()) {
            Object object = i$.next();
            Element property = (Element)object;
            properties.put(property.attributeValue("name"), property.attributeValue("value"));
        }

        ctx.setExtendsBase(properties);
    }

    public static void importClasses(Element root, Context ctx) throws Exception {
        List nodes = root.selectNodes("//context/importClasses/property");
        Properties properties = new Properties();
        Iterator i$ = nodes.iterator();

        while(i$.hasNext()) {
            Object object = i$.next();
            Element property = (Element)object;
            ArrayList<String> importClasses = new ArrayList<String>();
            List classStr = property.selectNodes("import");
            Iterator j$ = classStr.iterator();
            while(j$.hasNext()) {
                Object object2 = j$.next();
                Element importClass = (Element)object2;
                importClasses.add(importClass.attributeValue("value"));
            }
            properties.put(property.attributeValue("name"), importClasses);
        }

        ctx.setImportClasses(properties);
    }

    public static void parseTables(Element root, Context ctx) throws Exception {
        List tablesElement = root.elements("table");
        List tables = new ArrayList();
        Table table = null;
        Iterator i$ = tablesElement.iterator();

        while(i$.hasNext()) {
            Object object = i$.next();
            Element tableElement = (Element)object;
            table = new Table();
            String tableName = tableElement.attributeValue("tableName");
            if (tableName != null && !"".equals(tableName)) {
                String prefix = tableElement.attributeValue("prefix");
                if (prefix != null && !"".equals(prefix)) {
                    tableName = tableName.replace(prefix, "");
                }

                table.setTableName(tableElement.attributeValue("tableName"));
                String domainName = tableElement.attributeValue("domainObjectName");
                if (domainName == null || "".equals(domainName)) {
                    domainName = JavaBeanUtils.getCamelCaseString(tableName, true);
                }
                table.setExtendsBase(new HashMap<String, String>((Map) ctx.getExtendsBase()));


                table.setImportClasses(new HashMap<String, List<String>>((Map) ctx.getImportClasses()));

                table.setDomainName(domainName);
                table.setAnnotationName(JavaBeanUtils.firstLowerCase(table.getDomainName()));
                String packageName = tableElement.attributeValue("packageName");
                if (packageName != null && !"".equals(packageName)) {
                    table.setPackageName(packageName);
                    table.setPrefix(prefix);
                    Element generatedKeyElement = tableElement.element("generatedKey");
                    if (generatedKeyElement == null) {
                        throw new Exception("没有找到generatedKey节点");
                    }

                    String primaryKeyName = generatedKeyElement.attributeValue("column");
                    boolean bool = "true".equals(generatedKeyElement.attributeValue("identity"));
                    table.setPrimaryKey(new PrimariKey(primaryKeyName, bool));
                    Properties properties = new Properties();
                    List columnOveridsElement = tableElement.elements("columnOverid");
                    Iterator i$1 = columnOveridsElement.iterator();

                    while(i$1.hasNext()) {
                        Object obj = i$1.next();
                        Element columnOverid = (Element)obj;
                        properties.put(columnOverid.attributeValue("name"), columnOverid.attributeValue("javaType"));
                    }

                    table.setColumnOverids(properties);
                    Element voElment = tableElement.element("vo");
                    if (voElment != null) {
                        table.setVo(new Vo(table.getDomainName(), voElment.attributeValue("packageName")));
                    }

                    Element dtoElment = tableElement.element("dto");
                    if (dtoElment == null) {
                        throw new Exception("没有找到DTO节点,该节点必须存在");
                    }

                    table.setDto(new DTO(table.getDomainName(), dtoElment.attributeValue("packageName")));
                    String desc = tableElement.attributeValue("desc");
                    if (desc != null && !"".equals(desc)) {
                        table.setDesc(desc);
                    }

                    String author = tableElement.attributeValue("author");
                    if (author != null && !"".equals(author)) {
                        table.setAuthor(author);
                        tables.add(table);
                        continue;
                    }

                    throw new Exception("没有找到author属性，该属性必须存在");
                }

                throw new Exception("包名不能为空");
            }

            throw new Exception("表名为空");
        }

        ctx.setTables(tables);
    }
}
