package com.scritian.googlecourse;

import java.util.ArrayList;

public class Movie {
    private String name;
    private String shortDescription;
    private String genre;
    private float rating;
    private String photoBase64;
    private ArrayList<RelatedMovie> relatedMovieArrayList;

    public Movie(String name, String shortDescription,
                 String genre, float rating, String photoBase64,
                 ArrayList<RelatedMovie> relatedMovieArrayList) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.genre = genre;
        this.rating = rating;
        this.photoBase64 = photoBase64;
        this.relatedMovieArrayList = relatedMovieArrayList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getPhotoBase64() {
        return photoBase64;
    }

    public void setPhotoBase64(String photoBase64) {
        this.photoBase64 = photoBase64;
    }

    public ArrayList<RelatedMovie> getRelatedMovieArrayList() {
        return relatedMovieArrayList;
    }

    public void setRelatedMovieArrayList(ArrayList<RelatedMovie> relatedMovieArrayList) {
        this.relatedMovieArrayList = relatedMovieArrayList;
    }
}

