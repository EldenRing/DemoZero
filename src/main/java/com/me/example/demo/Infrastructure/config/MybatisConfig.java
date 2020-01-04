package com.me.example.demo.Infrastructure.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Chen Wei
 * @Date: Created in 21:02 2020/1/4
 */
@Configuration
@MapperScan("com.me.example.demo.repository.mapper")
public class MybatisConfig {
}
