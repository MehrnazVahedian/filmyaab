package com.example.film_yab;

public class MovieModel {

    private int id;
    private String title;
    private String Image;

    public int getId() {
        return id;
    }

    String getImage() {
        return Image;
    }

    String getTitle() {
        return title;
    }

    void setId(int id) {
        this.id = id;
    }

    void setImage(String image) {
        Image = image;
    }

    void setTitle(String title) {
        this.title = title;
    }
}
