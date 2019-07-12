package com.leicx.xxz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义配置
 */
@Configuration
public class CustomConfig implements WebMvcConfigurer {

    /**
     * 添加静态资源映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 和springboot默认的静态资源文件位置同时存在
        registry.addResourceHandler("/static/**")
                .addResourceLocations("file:/Users/daxiong/lcx/xxz-picture/");
    }
}


