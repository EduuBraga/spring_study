package com.eduubraga.delifood.notification;

import com.eduubraga.delifood.model.Client;

public interface Notifier {
    public void notify(Client client, String message);
}
