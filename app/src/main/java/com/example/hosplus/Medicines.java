package com.example.hosplus;

public class Medicines {
    private String name, prize,image;

    public Medicines(){}       //Blind constructor

    public Medicines(String name, String prize, String image) {
        this.name = name;
        this.prize = prize;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
