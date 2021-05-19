package com.example.hosplus;

public class Doctor {
    private String name, speciality, image;

    public Doctor(String image, String name, String speciality) {
        this.name = name;
        this.speciality = speciality;
        this.image = image;
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
}
