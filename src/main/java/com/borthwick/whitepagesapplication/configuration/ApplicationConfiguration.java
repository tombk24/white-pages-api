package com.borthwick.whitepagesapplication.configuration;

import com.borthwick.whitepagesapplication.WhitePageClient;
import com.borthwick.whitepagesapplication.controller.WhitePagesController;
import com.borthwick.whitepagesapplication.service.WhitePagesService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ApplicationConfiguration {

    @Bean
    WhitePagesController whitePagesController(WhitePagesService whitePagesService){
        return new WhitePagesController(whitePagesService);
    }

    @Bean
    WhitePagesService whitePagesService(WhitePageClient whitePageClient){
        return new WhitePagesService(whitePageClient);
    }

    @Bean
    WhitePageClient whitePageClient(){
        return new WhitePageClient();
    }
}
