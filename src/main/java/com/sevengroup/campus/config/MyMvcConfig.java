package com.sevengroup.campus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
//    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  //设置所有的请求可以进行跨域
                .allowedOrigins("http://localhost:8080")  //允许跨域的ip
                .allowedMethods("*")  //请求的方法 可以不设置 有默认的
                .allowedHeaders("*"); //请求头 可以不设置 有默认的
    }
}