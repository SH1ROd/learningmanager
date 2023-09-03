package com.learningmanager.sys;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;

import java.sql.Types;
import java.util.Collections;

public class codeGenerator {
    @Test
    public void demo01(){
        String url = "jdbc:mysql://localhost:3307/learning_manager";
        String username = "root";
        String password = "lqh88060618";
        String authorname = "lqw";
        String outputdir = "E:\\桌面\\java\\CRUD_project\\learningmanager\\src\\main\\java";
        String parentpackage = "com.learningmanager";
        String parentmoudle = "sys";
        String mapperxmldir = "E:\\桌面\\java\\CRUD_project\\learningmanager\\src\\main\\resources\\mapper\\" + parentmoudle;
        String tablename = "x_user";
        String tablepre = "x_";

        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author(authorname) // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件
                            .outputDir(outputdir); // 指定输出目录
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        // 自定义类型转换
                        return DbColumnType.INTEGER;
                    }
                    return typeRegistry.getColumnType(metaInfo);

                }))
                .packageConfig(builder -> {
                    builder.parent(parentpackage) // 设置父包名
                            .moduleName(parentmoudle) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, mapperxmldir)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tablename) // 设置需要生成的表名
                            .addTablePrefix(tablepre); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
