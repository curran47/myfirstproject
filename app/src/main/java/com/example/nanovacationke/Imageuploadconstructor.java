package com.example.nanovacationke;

public class Imageuploadconstructor {
    String image, placename;

    public Imageuploadconstructor(String image, String placename) {
        this.image = image;
        this.placename = placename;
    }

    public Imageuploadconstructor() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPlacename() {
        return placename;
    }

    public void setPlacename(String placename) {
        this.placename = placename;
    }
}
