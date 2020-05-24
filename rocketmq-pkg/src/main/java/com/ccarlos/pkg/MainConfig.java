package com.ccarlos.pkg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ccarlos.pkg.mapper")
@ComponentScan(basePackages = {"com.ccarlos.pkg.*", "com.ccarlos.pkg.config.*"})
public class MainConfig {

}
