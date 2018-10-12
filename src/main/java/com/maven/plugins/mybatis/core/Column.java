//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.maven.plugins.mybatis.core;

import com.maven.plugins.mybatis.utils.JavaBeanUtils;

public class Column {
    private String name;
    private String propertyName;
    private String dataType;
    private String jdbcType;
    private boolean isPrimaryKey;
    private String comment;
    private String getterName;
    private String setterName;

    public Column(String name, String dataType, String comment) {
        this.name = name;
        this.dataType = dataType;
        this.comment = comment;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getJdbcType() {
        return this.jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }

    public boolean isPrimaryKey() {
        return this.isPrimaryKey;
    }

    public void setPrimaryKey(boolean isPrimaryKey) {
        this.isPrimaryKey = isPrimaryKey;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getGetterName() {
        return JavaBeanUtils.getGetterMethodName(this.propertyName);
    }

    public String getSetterName() {
        return JavaBeanUtils.getSetterMethodName(this.propertyName);
    }

    public String toString() {
        return "Column [name=" + this.name + ", propertyName=" + this.propertyName + ", dataType=" + this.dataType + ", jdbcType=" + this.jdbcType + ", isPrimaryKey=" + this.isPrimaryKey + ", comment=" + this.comment + ", getterName=" + this.getterName + ", setterName=" + this.setterName + "]";
    }
}
