//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.maven.plugins.mybatis.generator;

import com.maven.plugins.mybatis.core.Context;
import com.maven.plugins.mybatis.core.Table;
import com.maven.plugins.mybatis.utils.FreemarkerUtils;
import com.maven.plugins.mybatis.utils.JavaBeanUtils;

public class ServiceGenerator {
    private static final String TEMPLATE_SERVICE = "freemaker-service";
    private static final String TEMPLATE_SERVICE_IMPL = "freemaker-service-impl";

    public ServiceGenerator() {
    }

    public static void process(Context ctx, Table table) throws Exception {
        StringBuilder sb = new StringBuilder(ctx.getMapper());
        sb.append(JavaBeanUtils.splitString(table.getPackageName()));
        sb.append("/service/");
        String service = sb.toString() + "I" + table.getDomainName() + "Service.java";
        FreemarkerUtils.write(service, FreemarkerUtils.process("freemaker-service", table));
        sb.append("impl/");
        sb.append(table.getDomainName()).append("ServiceImpl.java");
        FreemarkerUtils.write(sb.toString(), FreemarkerUtils.process("freemaker-service-impl", table));
    }
}
