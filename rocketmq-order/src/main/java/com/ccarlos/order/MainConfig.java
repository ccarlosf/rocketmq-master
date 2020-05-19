package com.ccarlos.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ccarlos.order.mapper")
@ComponentScan(basePackages = {"com.ccarlos.order.*", "com.ccarlos.order.config.*"})
public class MainConfig {

}
