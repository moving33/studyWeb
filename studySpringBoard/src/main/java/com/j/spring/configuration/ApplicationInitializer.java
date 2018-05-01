package com.j.spring.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
    public void onStartup(ServletContext servletContext) throws ServletException {
        //create root context
        AnnotationConfigWebApplicationContext rootContext
                = new AnnotationConfigWebApplicationContext();
        //context에 해당 내용 추가
        rootContext.register(ApplicationConfig.class);
        rootContext.register(DataConfig.class);
        rootContext.setServletContext(servletContext);

        //servletContext에 rootContext내용 추가
        servletContext.addListener(new ContextLoaderListener(rootContext));

        //Register and map the dispacher servlet
        ServletRegistration.Dynamic servletRegistration
                = servletContext.addServlet("dispatcher",new DispatcherServlet(rootContext));

        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("/");
    }
}
