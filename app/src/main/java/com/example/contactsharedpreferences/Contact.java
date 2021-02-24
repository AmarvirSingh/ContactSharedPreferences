package com.example.contactsharedpreferences;

import java.io.Serializable;

public class Contact implements Serializable {

    private String names;
    private String number;
    private String occupation;

    public Contact(String names, String number, String occupation) {
        this.names = names;
        this.number = number;
        this.occupation = occupation;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
