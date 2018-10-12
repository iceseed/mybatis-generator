//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.maven.plugins.mybatis.core;

import java.util.List;
import java.util.Properties;

public class Context {
    private String schema;
    private Properties jdbcProperties;
    private Properties javaTypeResolver;
    private Properties extendsBase;
    private Properties importClasses;
    private List<Table> tables;
    private String mapper;
    private String sqlmap;
    private String vo;

    public Context() {
    }

    public Properties getJdbcProperties() {
        return this.jdbcProperties;
    }

    public void setJdbcProperties(Properties jdbcProperties) {
        this.jdbcProperties = jdbcProperties;
    }

    public Properties getJavaTypeResolver() {
        return this.javaTypeResolver;
    }

    public void setJavaTypeResolver(Properties javaTypeResolver) {
        this.javaTypeResolver = javaTypeResolver;
    }

    public List<Table> getTables() {
        return this.tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public String getMapper() {
        return this.mapper;
    }

    public void setMapper(String mapper) {
        this.mapper = mapper;
    }

    public String getSqlmap() {
        return this.sqlmap;
    }

    public void setSqlmap(String sqlmap) {
        this.sqlmap = sqlmap;
    }

    public String getVo() {
        return this.vo;
    }

    public void setVo(String vo) {
        this.vo = vo;
    }

    public String getSchema() {
        return this.schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public Properties getExtendsBase() {
        return extendsBase;
    }

    public void setExtendsBase(Properties extendsBase) {
        this.extendsBase = extendsBase;
    }


    public Properties getImportClasses() {
        return importClasses;
    }

    public void setImportClasses(Properties importClasses) {
        this.importClasses = importClasses;
    }
}
