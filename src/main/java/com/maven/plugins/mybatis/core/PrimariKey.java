//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.maven.plugins.mybatis.core;

public class PrimariKey {
    private String columnName;
    private String propertyName;
    private String jdbcType;
    private boolean identity;

    public PrimariKey(String columnName, boolean identity) {
        this.columnName = columnName;
        this.identity = identity;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public boolean isIdentity() {
        return this.identity;
    }

    public void setIdentity(boolean identity) {
        this.identity = identity;
    }

    public String getJdbcType() {
        return this.jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String toString() {
        return "PrimariKey [columnName=" + this.columnName + ", propertyName=" + this.propertyName + ", jdbcType=" + this.jdbcType + ", identity=" + this.identity + "]";
    }
}
