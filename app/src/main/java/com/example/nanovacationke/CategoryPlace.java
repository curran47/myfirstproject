package com.example.nanovacationke;

public class CategoryPlace {

    String Image,Placename;

    public CategoryPlace() {
    }

    public CategoryPlace(String image, String placename) {
        Image = image;
        Placename = placename;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getPlacename() {
        return Placename;
    }

    public void setPlacename(String placename) {
        Placename = placename;
    }
}
