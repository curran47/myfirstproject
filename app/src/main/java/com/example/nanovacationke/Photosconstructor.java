package com.example.nanovacationke;



public class Photosconstructor {
    String button,image1,image2,image3,image4,text;

    public Photosconstructor(String button, String image1, String image2, String image3, String image4, String text) {
        this.button = button;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.text = text;
    }

    public Photosconstructor() {



    }



    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
