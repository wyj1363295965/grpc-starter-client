package com.wyj.demo.config.mybatisPlus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MybatisPlusConfig {

    //分页插件
    @Bean
    public MybatisPlusInterceptor paginationInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    /*
     * SQL执行效率插件,v3.2.0被移除
     * */
    @Bean
    @Profile({"dev", "test"})//设置dev test 环境开启，保证我们的效率
    public PaginationInnerInterceptor performanceInterceptor() {
        PaginationInnerInterceptor performanceInterceptor = new PaginationInnerInterceptor();
        performanceInterceptor.setMaxLimit(100L);//ms  设置SQL执行的最大时间，如果超过了则不执行
        performanceInterceptor.setDbType(DbType.MYSQL);
        //是否格式化代码
        performanceInterceptor.setOptimizeJoin(true);
        return performanceInterceptor;
    }
}
