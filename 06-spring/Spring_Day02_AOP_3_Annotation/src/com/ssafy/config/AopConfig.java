package com.ssafy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = { "com.ssafy.aspect, com.ssafy.board" })
@EnableAspectJAutoProxy
public class AopConfig {
}
