package com.j.spring.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

//톰캣 컨테이너에 Dispatcher 등록
public class ApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {

        /*CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        container.addFilter("characterEncodingFilter",characterEncodingFilter);*/

        //create root context,annotion 기반의 환경설정클래스를 의미함.


        AnnotationConfigWebApplicationContext rootContext
                = new AnnotationConfigWebApplicationContext();



        //DispatcherServlet설정
        rootContext.register(ApplicationConfig.class);
        //jasonConverter 설정
        rootContext.register(MvcConf.class);
        //Database 설정
        rootContext.register(DataConfig.class);


        ServletRegistration.Dynamic dispatcher
                = container.addServlet("dispatcher",new DispatcherServlet(rootContext));


        container.addListener(new ContextLoaderListener(rootContext));



        dispatcher.addMapping("/");
        dispatcher.setLoadOnStartup(1);

    }
}
