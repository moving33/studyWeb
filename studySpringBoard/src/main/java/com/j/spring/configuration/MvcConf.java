package com.j.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.Arrays;
import java.util.List;

@Configuration
public class MvcConf extends WebMvcConfigurationSupport {
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        converters.add(jsonConverter());
        addDefaultHttpMessageConverters(converters);
    }



    @Bean
    MappingJackson2HttpMessageConverter jsonConverter(){
        MappingJackson2HttpMessageConverter converter
                = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.valueOf("application/json;charset=UTF-8")));
        return converter;
    }
}
