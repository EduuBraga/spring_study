package com.eduubraga.delifood;

import com.eduubraga.delifood.notification.EmailNotification;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Bean
    public EmailNotification emailNotification() {
        EmailNotification notifier = new EmailNotification("smtp.email.com.br");
        notifier.setCapsLock(true);

        return notifier;
    }

}
