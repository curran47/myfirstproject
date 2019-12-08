package com.example.nanovacationke;

public class imageuploadconstructor {
    String image, placename,search;

    public String getImage() {
        return image;
    }

    public String getPlacename() {
        return placename;
    }

    public String getSearch() {
        return search;
    }

    public imageuploadconstructor(String image, String placename, String search) {
        this.image = image;
        this.placename = placename;
        this.search = search;



    }

    public imageuploadconstructor(String pplacename, String s) {
    }
}
