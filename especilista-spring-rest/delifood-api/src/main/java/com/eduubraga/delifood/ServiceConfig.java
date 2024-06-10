package com.eduubraga.delifood;

import com.eduubraga.delifood.service.ClientActivationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public ClientActivationService clientActivationService() {
        return new ClientActivationService();
    }

}