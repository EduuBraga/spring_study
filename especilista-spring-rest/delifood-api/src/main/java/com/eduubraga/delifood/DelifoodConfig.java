package com.eduubraga.delifood;

import com.eduubraga.delifood.notification.EmailNotification;
import com.eduubraga.delifood.service.ClientActivationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class DelifoodConfig {

    @Bean
    public EmailNotification emailNotification() {
        EmailNotification notifier = new EmailNotification("smtp.email.com.br");
        notifier.setCapsLock(true);

        return notifier;
    }

    @Bean
    public ClientActivationService clientActivationService() {
        return new ClientActivationService(emailNotification());
    }

}
