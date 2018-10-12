//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.maven.plugins.mybatis.core;

import java.text.SimpleDateFormat;
import java.util.*;

public class Table {
    private String packageName;
    private String tableName;
    private String domainName;
    private String prefix;
    private PrimariKey primaryKey;
    private Vo vo;
    private DTO dto;
    private List<Column> columns;
    private Map<String, String> extendsBase;
    private Map<String, List<String>> importClasses;
    private Properties columnOverids;
    private String desc;
    private String annotationName;
    private String date;
    private String author;

    public Table() {
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDomainName() {
        return this.domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public PrimariKey getPrimaryKey() {
        return this.primaryKey;
    }

    public void setPrimaryKey(PrimariKey primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Vo getVo() {
        return this.vo;
    }

    public void setVo(Vo vo) {
        this.vo = vo;
    }

    public List<Column> getColumns() {
        return this.columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public Properties getColumnOverids() {
        return this.columnOverids;
    }

    public void setColumnOverids(Properties columnOverids) {
        this.columnOverids = columnOverids;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAnnotationName() {
        return this.annotationName;
    }

    public void setAnnotationName(String annotationName) {
        this.annotationName = annotationName;
    }

    public DTO getDto() {
        return this.dto;
    }

    public void setDto(DTO dto) {
        this.dto = dto;
    }

    public String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        this.setDate(sdf.format(new Date()));
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Map<String, String> getExtendsBase() {
        return extendsBase;
    }

    public void setExtendsBase(Map<String, String> extendsBase) {
        this.extendsBase = extendsBase;
    }

    public Map<String, List<String>> getImportClasses() {
        return importClasses;
    }

    public void setImportClasses(Map<String, List<String>> importClasses) {
        this.importClasses = importClasses;
    }
}
