package com.enginizer.testing;


import com.enginizer.testing.config.DriverConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

@Configuration
@Import({ DriverConfig.class })
@ComponentScan("com.enginizer.testing")
public class TestApplication {


    @Bean
        public PropertyPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
            PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
            configurer.setSearchSystemEnvironment(true);
            configurer.setIgnoreResourceNotFound(true);
            String configPath = System.getProperty("config.path");

            configurer.setLocation(new ClassPathResource("conf/application.properties"));
            if (StringUtils.isNotEmpty(configPath)) {
                configurer.setLocation(new FileSystemResource(configPath + "conf/application.properties"));
            }
            return configurer;
        }
    }