package com.eduubraga.delifood.di.notification;

import com.eduubraga.delifood.di.model.Client;

public interface Notifier {
    public void notify(Client client, String message);
}
