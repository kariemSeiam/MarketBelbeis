package com.erots.marketbelbeis.ui.main.home.home_cat_bar;

public class HomeBarCatsModel {
    int adImage;
    String title;
    int idCat;

    public HomeBarCatsModel(int adImage, String title) {
        this.adImage = adImage;
        this.title = title;
    }

    public int getAdImage() {
        return adImage;
    }

    public void setAdImage(int adImage) {
        this.adImage = adImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
