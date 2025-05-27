package com.campusdual;

public class Video extends Post {

    private String quality;
    private int duration;


    public Video(String title, String quality, int duration) {
        super(title);
        this.quality = quality;
        this.duration = duration;
    }


    public String getQuality() {
        return quality;
    }

    public int getDuration() {
        return duration;
    }
}
