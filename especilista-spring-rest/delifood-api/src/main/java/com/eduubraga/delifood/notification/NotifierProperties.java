package com.eduubraga.delifood.notification;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("notifier.email")
public class NotifierProperties {

    private String serverHost;
    private Integer serverPort = 40;

    public String getServerHost() {
        return serverHost;
    }

    public void setServerHost(String serverHost) {
        this.serverHost = serverHost;
    }

    public Integer getServerPort() {
        return serverPort;
    }

    public void setServerPort(Integer serverPort) {
        this.serverPort = serverPort;
    }
}
