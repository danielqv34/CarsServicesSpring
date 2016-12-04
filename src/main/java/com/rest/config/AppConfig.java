package com.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by ezequ on 12/3/2016.
 */

@Configuration
@ComponentScan(basePackages = {"com.rest.*"})
@Import(value = {HibernateConfig.class,WebConfig.class})
public class AppConfig {
}
