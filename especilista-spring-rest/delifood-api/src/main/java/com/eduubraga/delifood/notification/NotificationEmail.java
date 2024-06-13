package com.eduubraga.delifood.notification;

import com.eduubraga.delifood.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("prod")
@NotifierType(UrgencyLevel.URGENT)
@Component
public class NotificationEmail implements Notifier {

    @Autowired
    private NotifierProperties properties;

    @Override
    public void notify(Client client, String message) {
        System.out.println("Host: " + properties.getServerHost());
        System.out.println("Port: " + properties.getServerPort());

        System.out.printf("Notificando %s atráves do e-mail %s: %s%n",
                client.getName(), client.getEmail(), message);
    }

}