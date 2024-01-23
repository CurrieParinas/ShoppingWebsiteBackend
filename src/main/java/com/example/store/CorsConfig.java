package com.example.store;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:5123") // Add your frontend URL here
            .allowedOrigins("https://shopping-website-121.vercel.app") 
//            .allowedOrigins("https://docclickconnect.vercel.app") // Add your frontend URL here
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowCredentials(true); // If you need to include cookies in the request
    }
}
