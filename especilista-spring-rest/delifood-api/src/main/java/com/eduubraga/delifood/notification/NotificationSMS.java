package com.eduubraga.delifood.notification;

import com.eduubraga.delifood.model.Client;
import org.springframework.stereotype.Component;

@NotifierType(UrgencyLevel.NORMAL)
@Component
public class NotificationSMS implements Notifier {

    @Override
    public void notify(Client client, String message) {
        System.out.printf("Notificando %s por SMS através do telefone %s: %s%n",
                client.getName(), client.getTelephone(), message);
    }

}
