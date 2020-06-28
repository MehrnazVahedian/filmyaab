package com.example.film_yab;

import java.io.Serializable;

public class MovieModel implements Serializable {


    private int id;
    private String title;
    private String Image;
    private String overview;

    public int getId() {
        return id;
    }

    String getImage() {
        return Image;
    }

    String getTitle() {
        return title;
    }

    String getOverview(){return overview; }

    void setId(int id) {
        this.id = id;
    }

    void setImage(String image) {
        Image = image;
    }

    void setTitle(String title) {
        this.title = title;
    }

    void setOverview(String overview) { this.overview = overview; }
}
