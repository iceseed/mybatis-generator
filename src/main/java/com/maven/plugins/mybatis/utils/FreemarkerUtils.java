//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.maven.plugins.mybatis.utils;

import com.maven.plugins.mybatis.core.Table;
import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;

public class FreemarkerUtils {
    private static Configuration cfg = new Configuration();
    private static PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
    private static String suffix = ".ftl";
    private static String folderName = "rbj-generator";
    private static String tmpdir;
    private static String[] templatesName;

    public FreemarkerUtils() {
    }

    public static void processBefore() throws Exception {
        File tmpFile = new File(tmpdir);
        if (!tmpFile.exists()) {
            tmpFile.mkdirs();
        }

        String[] var1 = templatesName;
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            String templateName = var1[var3];
            Resource resource = patternResolver.getResource("classpath:META-INF/" + templateName + suffix);
            FileCopyUtils.copy(resource.getInputStream(), new FileOutputStream(new File(tmpdir, templateName + suffix)));
        }

        FileTemplateLoader templateLoader = new FileTemplateLoader(new File(tmpdir));
        cfg.setTemplateLoader(templateLoader);
    }

    public static void processEnd() throws Exception {
        if (!FileSystemUtils.deleteRecursively(new File(tmpdir))) {
            System.out.println("---------------删除临时文件异常-----------------");
        }

    }

    public static String process(String templateName, Table table) throws Exception {
        Template temp = cfg.getTemplate(templateName + suffix, "utf-8");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        temp.process(table, new OutputStreamWriter(bos));
        return bos.toString("UTF-8");
    }

    public static void write(String path, String content) throws Exception {
        File generatorFile = new File(path);
        if (generatorFile.isDirectory()) {
            throw new Exception(path + "不是一个文件");
        } else {
            File parentFile = generatorFile.getParentFile();
            if (!parentFile.exists() && !parentFile.mkdirs()) {
                throw new Exception("文件夹创建失败");
            } else if (!generatorFile.exists()) {
                FileCopyUtils.copy(content, new BufferedWriter(new OutputStreamWriter(new FileOutputStream(generatorFile), "UTF-8")));
                System.out.println("save:" + path);
            }
        }
    }

    static {
        tmpdir = System.getProperty("java.io.tmpdir") + folderName + "/";
        templatesName = new String[]{"freemaker-domain", "freemaker-mapper", "freemaker-sqlmap", "freemaker-service", "freemaker-service-impl", "freemaker-vo", "freemaker-dto"};
        cfg.setDefaultEncoding("UTF-8");
    }
}
