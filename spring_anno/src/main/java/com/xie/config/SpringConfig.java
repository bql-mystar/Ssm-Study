package com.xie.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration // 设置该类为配置类
@ComponentScan("com.xie")  // 设置组件扫描
@Import(DataSourceConfig.class)
public class SpringConfig {

}
