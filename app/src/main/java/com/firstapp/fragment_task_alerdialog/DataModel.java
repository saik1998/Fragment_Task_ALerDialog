package com.firstapp.fragment_task_alerdialog;

public class DataModel {
    String name;
    String mail;
    String address;
    String mobilenumber;
    String desgnation;

    public DataModel(String name, String mail, String address, String mobilenumber, String desgnation) {
        this.name = name;
        this.mail = mail;
        this.address = address;
        this.mobilenumber = mobilenumber;
        this.desgnation = desgnation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getDesgnation() {
        return desgnation;
    }

    public void setDesgnation(String desgnation) {
        this.desgnation = desgnation;
    }
}
