package com.eduubraga.delifood.di.model;

public class Client {

    private String name;
    private String email;
    private String telephone;
    private boolean active = false;

    public Client(String email, String name, String telephone) {
        this.email = email;
        this.name = name;
        this.telephone = telephone;
    }

    public boolean isActive() {
        return active;
    }

    public void activete() {
        this.active = true;
    }

    public void disable() {
        this.active = false;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Client{" +
                "active=" + active +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
