package com.example.mobilki5;


public class Car {
    private String make;
    private String model;
    private int year;
    private int imageResource;
    private String info;
    private int videoResource;
    private int audioResource;

    public Car(String make, String model, int year, int imageResource, String info, int videoResource, int audioResource) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.imageResource = imageResource;
        this.info = info;
        this.videoResource = videoResource;
        this.audioResource = audioResource;
    }

    // Getters and Setters

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getInfo() {
        return info;
    }

    public int getVideoResource() {
        return videoResource;
    }

    public int getAudioResource() {
        return audioResource;
    }
}