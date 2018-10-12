//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.maven.plugins.mybatis.generator;

import com.maven.plugins.mybatis.core.Context;
import com.maven.plugins.mybatis.core.Table;
import com.maven.plugins.mybatis.utils.FreemarkerUtils;
import com.maven.plugins.mybatis.utils.JavaBeanUtils;

public class VoGenerator {
    private static final String TEMPLATE_NAME = "freemaker-vo";

    public VoGenerator() {
    }

    public static void process(Context ctx, Table table) throws Exception {
        if (table.getVo() != null) {
            StringBuilder sb = new StringBuilder(ctx.getVo());
            sb.append(JavaBeanUtils.splitString(table.getVo().getPackageName()));
            sb.append("/");
            sb.append(table.getDomainName()).append("VO.java");
            FreemarkerUtils.write(sb.toString(), FreemarkerUtils.process("freemaker-vo", table));
        }
    }
}
