package com.example.disasterprepfrontend;

import java.io.Serializable;

public class ModelContact implements Serializable {
    String contactName;
    String contactPhoneNumber;

    public ModelContact(String contactName, String contactPhoneNumber) {
        this.contactName = contactName;
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

}
