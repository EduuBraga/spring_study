package com.eduubraga.delifood.notification;

import com.eduubraga.delifood.model.Client;

public class EmailNotification implements Notifier {

    private boolean capsLock;
    private String hostServerSMTP;

    public EmailNotification(String hostServerSMTP) {
        this.hostServerSMTP = hostServerSMTP;
        System.out.println("EmailNotificantion");
    }

    @Override
    public void notify(Client client, String message){
        if(this.capsLock) {
            message = message.toUpperCase();
        }

        System.out.printf("Notificando %s atráves do e-mail %s: %s%n", client.getName(), client.getEmail(), message);
    }

    public void setCapsLock(boolean capsLock) {
        this.capsLock = capsLock;
    }
}
