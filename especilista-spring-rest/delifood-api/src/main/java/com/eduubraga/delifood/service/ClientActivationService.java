package com.eduubraga.delifood.service;

import com.eduubraga.delifood.model.Client;
import com.eduubraga.delifood.notification.Notifier;
import com.eduubraga.delifood.notification.NotifierType;
import com.eduubraga.delifood.notification.UrgencyLevel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientActivationService {

    @NotifierType(UrgencyLevel.URGENT)
    @Autowired
    private Notifier notifier;

    public void activate(Client client) {
        client.activete();

        notifier.notify(client, "Cadastro de cliente ativado!");
    }

}