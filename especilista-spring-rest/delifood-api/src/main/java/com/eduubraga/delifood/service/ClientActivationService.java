package com.eduubraga.delifood.service;

import com.eduubraga.delifood.model.Client;
import com.eduubraga.delifood.notification.Notifier;

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
