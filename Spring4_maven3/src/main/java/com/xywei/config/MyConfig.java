package com.xywei.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.xywei.*")
@EnableAspectJAutoProxy // 开启spring对aspectj的支持
public class MyConfig {

}
