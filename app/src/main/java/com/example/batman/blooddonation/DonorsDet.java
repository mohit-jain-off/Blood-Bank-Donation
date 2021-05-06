package com.example.batman.blooddonation;

import java.io.Serializable;

public class DonorsDet implements Serializable {
    String place,name,contact;

    public DonorsDet(String place, String name, String contact) {
        this.place = place;
        this.name = name;
        this.contact = contact;
    }

    public DonorsDet() {

    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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
