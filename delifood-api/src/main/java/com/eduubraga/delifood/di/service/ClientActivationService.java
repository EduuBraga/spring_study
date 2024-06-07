package com.eduubraga.delifood.di.service;

import com.eduubraga.delifood.di.model.Client;
import com.eduubraga.delifood.di.notification.EmailNotification;
import com.eduubraga.delifood.di.notification.Notifier;
import org.springframework.stereotype.Component;

@Component
public class ClientActivationService {
    private final Notifier notifier;

    public ClientActivationService(Notifier notifier) {
        this.notifier = notifier;

        System.out.println("ClientActivationService " + notifier);
    }

    public void activate(Client client) {
        client.activete();

        notifier.notify(client, "Cadastro de cliente ativo!");
    }
}
