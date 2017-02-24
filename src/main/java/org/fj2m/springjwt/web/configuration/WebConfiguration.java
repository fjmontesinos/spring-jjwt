package org.fj2m.springjwt.web.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created by javier-montesinos on 24/02/17.
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("**/*.css",
                "**/*.js",
                "**/*.map",
                "*.html").addResourceLocations("classpath:META-INF/resources/").setCachePeriod(0);
    }
}
