package com.example.hosplus;

public class Doctor {
    private String name, speciality, image, info,mail;

    public Doctor(){}        //Blind constructor

    public Doctor(String name, String speciality, String image, String info, String mail) {
        this.name = name;
        this.speciality = speciality;
        this.image = image;
        this.info = info;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
