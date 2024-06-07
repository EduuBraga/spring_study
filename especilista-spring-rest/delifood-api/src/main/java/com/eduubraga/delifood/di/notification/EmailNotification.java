package com.eduubraga.delifood.di.notification;

import com.eduubraga.delifood.di.model.Client;
import org.springframework.stereotype.Component;

@Component
public class EmailNotification implements Notifier {

    public EmailNotification() {
        System.out.println("EmailNotificantion on");
    }

    @Override
    public void notify(Client client, String message){
        System.out.printf("Notificando %s atráves do e-mail %s: %s%n", client.getName(), client.getEmail(), message);
    }

}
