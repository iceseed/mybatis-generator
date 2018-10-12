//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.maven.plugins.mybatis.utils;

import com.maven.plugins.mybatis.core.Column;
import com.maven.plugins.mybatis.core.Context;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DbUtils {
    public DbUtils() {
    }

    public static List<Column> getColumns(Context ctx, String tableName) {
        Connection conn = null;
        Statement stmt = null;
        ArrayList result = new ArrayList();

        try {
            Properties properties = ctx.getJdbcProperties();
            Class.forName(properties.getProperty("driverClass", "com.mysql.jdbc.Driver"));
            conn = DriverManager.getConnection(properties.getProperty("connectionURL"), properties.getProperty("uName"), properties.getProperty("password"));
            stmt = conn.createStatement();
            StringBuilder sql = new StringBuilder("select  column_name, column_comment, column_type from information_schema.columns where ");
            sql.append("table_schema ='" + ctx.getSchema() + "' and ").append("table_name = '" + tableName + "'");

            ResultSet rs;
            String type;
            for(rs = stmt.executeQuery(sql.toString()); rs.next(); result.add(new Column(rs.getString("column_name"), type, rs.getString("column_comment")))) {
                type = rs.getString("column_type");
                if (type.indexOf("(") != -1) {
                    type = type.substring(0, type.indexOf("("));
                }
            }

            rs.close();
        } catch (SQLException var24) {
            var24.printStackTrace();
        } catch (Exception var25) {
            var25.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException var23) {
                ;
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException var22) {
                var22.printStackTrace();
            }

        }

        return result;
    }
}
