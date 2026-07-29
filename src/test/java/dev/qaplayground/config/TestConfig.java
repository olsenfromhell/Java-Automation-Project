package dev.qaplayground.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"dev.qaplayground.config", "dev.qaplayground.pages"})
public class TestConfig {}
