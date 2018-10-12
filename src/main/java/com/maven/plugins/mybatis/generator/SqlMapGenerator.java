//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.maven.plugins.mybatis.generator;

import com.maven.plugins.mybatis.core.Context;
import com.maven.plugins.mybatis.core.Table;
import com.maven.plugins.mybatis.utils.FreemarkerUtils;

public class SqlMapGenerator {
    private static final String TEMPLATE_NAME = "freemaker-sqlmap";

    public SqlMapGenerator() {
    }

    public static void process(Context ctx, Table table) throws Exception {
        StringBuilder sb = new StringBuilder(ctx.getSqlmap());
        sb.append("/");
        sb.append(table.getDomainName()).append("Mapper.xml");
        FreemarkerUtils.write(sb.toString(), FreemarkerUtils.process("freemaker-sqlmap", table));
    }
}
