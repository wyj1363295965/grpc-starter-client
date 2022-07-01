package com.wyj.demo.config.mybatisPlus;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;

import java.util.Collections;

/**
 * v3.5.2
 */
public class Generator {

    private static final String URL = "jdbc:mysql://121.37.225.158:23306/ally_fleet?characterEncoding=UTF-8&useSSL=false&useUnicode=true&autoReconnect=true&allowMultiQueries=true&allowPublicKeyRetrieval=true";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "admin";
    private static final DataSourceConfig.Builder DATA_CONFIG_BUILDER =
            new DataSourceConfig.Builder(URL, USER_NAME, PASSWORD)
                    .dbQuery(new MySqlQuery())//可设置不同类型数据库
                    .schema("public")
                    .typeConvert(new MySqlTypeConvert())
                    .keyWordsHandler(new MySqlKeyWordsHandler());

    public static void main(String[] args) {
        String userName = System.getProperty("user.name");
        String parentPathCom = System.getProperty("user.dir");

        //parentPath: 项目路径--到/src/main 此处为默认值
        final String parentPath = parentPathCom + "/src/main";

        final String projectPath = parentPath + "/java";
        FastAutoGenerator.create(DATA_CONFIG_BUILDER)
                //全局设置
                .globalConfig(builder -> {
                    // 设置作者
                    builder.author(userName)
                            // 覆盖已生成文件
                            .fileOverride()
                            .enableSwagger()
                            //执行完毕后禁止打开目录
                            .disableOpenDir()
                            // 指定输出目录
                            .outputDir(projectPath);
                })
                //包设置
                .packageConfig(builder -> {
                    // 设置父包名
                    builder.parent("com.wyj.demo")
                            // 设置父包模块名
//                            .moduleName("system")
                            // 设置mapperXml生成路径
                            .pathInfo(Collections.singletonMap(OutputFile.xml, parentPath + "/resources/mapper"));
                })
                //策略设置
                .strategyConfig(builder ->
                        //数据库表
                        builder.addInclude("tb_user")
                                // 设置过滤表前缀
                                .addTablePrefix("tb_", "c_")
                                //通用查询结果列和通用查询映射结果
                                .mapperBuilder().enableBaseColumnList().enableBaseResultMap()
                                //去掉service接口开头的字母I
                                .serviceBuilder().formatServiceFileName("%sService")
                                //以RESTful风格生成controller
                                .controllerBuilder().enableRestStyle()
                                //数据库字段转实体属性风格--驼峰
                                .entityBuilder().columnNaming(NamingStrategy.underline_to_camel)
                                //链式编程
                                .enableChainModel()
                                //设置列名称 表名称
                                .enableTableFieldAnnotation()
                                //启用lombok注解
                                .enableLombok()
                )
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

}
