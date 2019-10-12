package ru.trapeznikov.database.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ };
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ };
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
