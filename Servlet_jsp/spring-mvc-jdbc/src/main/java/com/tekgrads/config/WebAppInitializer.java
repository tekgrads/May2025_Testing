package com.tekgrads.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { AppConfig.class }; // App-level beans
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebMvcConfig.class }; // MVC config
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" }; // Map DispatcherServlet to /
    }
}
