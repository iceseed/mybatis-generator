//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.maven.plugins.mybatis.generator;

import com.maven.plugins.mybatis.core.Context;
import com.maven.plugins.mybatis.core.Table;
import com.maven.plugins.mybatis.utils.FreemarkerUtils;
import com.maven.plugins.mybatis.utils.JavaBeanUtils;

public class DomainGenerator {
    private static final String TEMPLATE_NAME = "freemaker-domain";

    public DomainGenerator() {
    }

    public static void process(Context ctx, Table table) throws Exception {
        StringBuilder sb = new StringBuilder(ctx.getMapper());
        sb.append(JavaBeanUtils.splitString(table.getPackageName()));
        sb.append("/domain/");
        sb.append(table.getDomainName()).append("Domain.java");
        FreemarkerUtils.write(sb.toString(), FreemarkerUtils.process("freemaker-domain", table));
    }
}
