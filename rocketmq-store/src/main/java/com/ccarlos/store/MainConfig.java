package com.ccarlos.store;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ccarlos.store.mapper")
@ComponentScan(basePackages = {"com.ccarlos.store.*", "com.ccarlos.store.config.*"})
public class MainConfig {

}
