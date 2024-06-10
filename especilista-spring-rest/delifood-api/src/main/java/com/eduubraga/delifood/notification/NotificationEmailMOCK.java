package com.eduubraga.delifood.notification;

import com.eduubraga.delifood.model.Client;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@NotifierType(UrgencyLevel.URGENT)
@Component
public class NotificationEmailMOCK implements Notifier {

    public NotificationEmailMOCK() {
        System.out.println("NotificationEmail MOCK");
    }

    @Override
    public void notify(Client client, String message) {
        System.out.printf("Notificação para %s seria feita atráves do e-mail %s: %s%n",
                client.getName(), client.getEmail(), message);
    }

}