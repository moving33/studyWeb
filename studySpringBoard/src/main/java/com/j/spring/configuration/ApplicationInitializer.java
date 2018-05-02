package com.j.spring.configuration;

import com.j.test.TestConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

//톰캣 컨테이너에 Dispatcher 등록
public class ApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        //create root context,annotion 기반의 환경설정클래스를 의미함.
        AnnotationConfigWebApplicationContext rootContext
                = new AnnotationConfigWebApplicationContext();

        AnnotationConfigWebApplicationContext textContext
                = new AnnotationConfigWebApplicationContext();

        AnnotationConfigWebApplicationContext empty
                = new AnnotationConfigWebApplicationContext();


        //context에 해당 내용 추가
        textContext.register(TestConfig.class);


        rootContext.register(TestConfig.class);
        //DispatcherServlet설정
        rootContext.register(ApplicationConfig.class);
        //Database 설정
        rootContext.register(DataConfig.class);

        ServletRegistration.Dynamic dispatcher
                = container.addServlet("dispatcher",new DispatcherServlet(empty));



        //servletContext에 rootContext내용 추가
        /*container.addListener(new ContextLoaderListener(rootContext));*/


        container.addListener(new ContextLoaderListener(rootContext));

        //Register and map the dispacher servlet


        ServletRegistration.Dynamic test =
                container.addServlet("test",new DispatcherServlet(textContext));

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        test.setLoadOnStartup(1);
        test.addMapping("/test.do");

        /*test.setLoadOnStartup(2);
        test.addMapping("/test/*.do");*/
    }
}
