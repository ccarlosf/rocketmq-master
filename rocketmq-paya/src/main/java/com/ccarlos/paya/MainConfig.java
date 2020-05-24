package com.ccarlos.paya;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ccarlos.paya.mapper")
@ComponentScan(basePackages = {"com.ccarlos.paya.*", "com.ccarlos.paya.config.*"})
public class MainConfig {

}
