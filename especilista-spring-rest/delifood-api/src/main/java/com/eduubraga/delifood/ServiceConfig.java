package com.eduubraga.delifood;

import com.eduubraga.delifood.notification.Notifier;
import com.eduubraga.delifood.service.ClientActivationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public ClientActivationService clientActivationService(Notifier notifier) {
        return new ClientActivationService(notifier);
    }

}
