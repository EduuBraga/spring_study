package com.eduubraga.delifood.notification;

import com.eduubraga.delifood.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@NotifierType(UrgencyLevel.URGENT)
@Component
public class NotificationEmailMOCK implements Notifier {

    @Autowired
    private NotifierProperties notifierProperties;

    @Override
    public void notify(Client client, String message) {
        System.out.printf("MOCK: Notificação para %s seria feita atráves do e-mail %s utilizando %s: %s%n",
                client.getName(), client.getEmail(), notifierProperties.getServerHost(), message);
    }

}