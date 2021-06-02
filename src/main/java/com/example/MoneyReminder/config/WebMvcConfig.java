package com.example.MoneyReminder.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(Endpoints.HOME).setViewName(ViewNames.HOME);
        registry.addViewController(Endpoints.LOGIN).setViewName(ViewNames.LOGIN);
        registry.addViewController(Endpoints.FRIENDS).setViewName(ViewNames.FRIENDS);
        registry.addViewController(Endpoints.ALLFRIENDS).setViewName(ViewNames.ALLFRIENDS);
        registry.addViewController(Endpoints.CREATFRIEND).setViewName(ViewNames.CREATFRIEND);

    }
}





