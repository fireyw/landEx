package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;



@ComponentScan
//@EnableWebMvc//이것을 붙이는 순간 스프링 부트가 제공하는 자동설정을 사용 할 수 없다
               //application.properties에서 먼저 커스터마이징을 사용하자

public class WebConfig {
    @Bean
    public HandlerMapping handlerMapping(){
        RequestMappingHandlerMapping handlerMapping=new RequestMappingHandlerMapping(); //이거 자체는 스프링부트에서 제공해주는것과 동일
        handlerMapping.setInterceptors();
        return handlerMapping;
    }

    //메소드 파라미터 세팅가능
    @Bean
    public HandlerAdapter handlerAdapter(){
        RequestMappingHandlerAdapter handlerAdapter=new RequestMappingHandlerAdapter();

        return handlerAdapter;

    }
}
