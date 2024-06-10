package com.eduubraga.delifood.service;

import com.eduubraga.delifood.model.Client;
import com.eduubraga.delifood.notification.Notifier;
import com.eduubraga.delifood.notification.NotifierType;
import com.eduubraga.delifood.notification.UrgencyLevel;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class ClientActivationService {

    @NotifierType(UrgencyLevel.URGENT)
    @Autowired
    private Notifier notifier;

//    @PostConstruct
    public void init() {
        System.out.println("INIT " + notifier);
    }

//    @PreDestroy
    public void destroy() {
        System.out.println("DESTROY");
    }

    public void activate(Client client) {
        client.activete();

        notifier.notify(client, "Cadastro de cliente ativo!");
    }

}