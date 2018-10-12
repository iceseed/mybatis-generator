//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.maven.plugins.mybatis;

import com.maven.plugins.mybatis.utils.GeneratorUtils;
import java.io.File;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/** @deprecated */
@Mojo(
        name = "mybatis"
)
public class GeneratorMojo extends AbstractMojo {
    @Parameter(
            defaultValue = "${project.build.directory}",
            property = "outputDir",
            required = true
    )
    private String mapper;
    @Parameter(
            defaultValue = "${project.build.directory}",
            property = "outputDir",
            required = true
    )
    private String sqlmap;
    @Parameter(
            defaultValue = "${project.build.directory}",
            property = "outputDir",
            required = true
    )
    private String vo;
    @Parameter(
            defaultValue = "${project.build.directory}",
            property = "outputDir",
            required = true
    )
    private String configDirectory;

    public GeneratorMojo() {
    }

    public void execute() throws MojoExecutionException {
        File context = new File(this.configDirectory);
        if (!context.isDirectory() && context.exists()) {
            File mapperFile = new File(this.mapper);
            if (!mapperFile.isDirectory()) {
                this.getLog().error(new Exception("mapper:" + this.mapper + ",必须是一个文件夹"));
            } else {
                File sqlmapFile = new File(this.sqlmap);
                if (!sqlmapFile.isDirectory()) {
                    this.getLog().error(new Exception("sqlmap:" + this.sqlmap + ",必须是一个文件夹"));
                } else {
                    File voFile = new File(this.vo);
                    if (!voFile.isDirectory()) {
                        this.getLog().error(new Exception("vo:" + this.vo + ",必须是一个文件夹"));
                    } else {
                        try {
                            GeneratorUtils.runner(this.mapper, this.sqlmap, this.vo, this.configDirectory);
                        } catch (Exception var6) {
                            this.getLog().error(var6);
                        }

                    }
                }
            }
        } else {
            this.getLog().error(new Exception("configDirectory:" + this.configDirectory + ",必须是一个文件"));
        }
    }
}
