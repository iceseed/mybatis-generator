//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.maven.plugins.mybatis.generator;

import com.maven.plugins.mybatis.core.Context;
import com.maven.plugins.mybatis.core.Table;
import com.maven.plugins.mybatis.utils.FreemarkerUtils;
import com.maven.plugins.mybatis.utils.JavaBeanUtils;

public class MapperGenerator {
    private static final String TEMPLATE_NAME = "freemaker-mapper";

    public MapperGenerator() {
    }

    public static void process(Context ctx, Table table) throws Exception {
        StringBuilder sb = new StringBuilder(ctx.getMapper());
        sb.append(JavaBeanUtils.splitString(table.getPackageName()));
        sb.append("/mapper/");
        sb.append(table.getDomainName()).append("Mapper.java");
        FreemarkerUtils.write(sb.toString(), FreemarkerUtils.process("freemaker-mapper", table));
    }
}
