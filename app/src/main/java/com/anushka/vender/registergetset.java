package com.anushka.vender;

public class registergetset {
    public String name;
    public String contact;

    public registergetset() {
    }

    public registergetset(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
