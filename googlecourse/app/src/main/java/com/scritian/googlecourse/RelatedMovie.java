package com.scritian.googlecourse;

public class RelatedMovie {
    private String  name;
    private String photoBase64;
    private float rating;

    public RelatedMovie(String name, String photoBase64, float rating) {
        this.name = name;
        this.photoBase64 = photoBase64;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoBase64() {
        return photoBase64;
    }

    public void setPhotoBase64(String photoBase64) {
        this.photoBase64 = photoBase64;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}