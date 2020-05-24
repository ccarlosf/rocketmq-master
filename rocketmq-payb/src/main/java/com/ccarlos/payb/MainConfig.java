package com.ccarlos.payb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ccarlos.payb.mapper")
@ComponentScan(basePackages = {"com.ccarlos.payb.*", "com.ccarlos.payb.config.*"})
public class MainConfig {

}
