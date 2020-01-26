package com.jkapps.cardviewwithrecyclerview;

public class Model {

    int image;
    String title;
    String description;
    String shopUrl;



    public Model(int image, String title, String description, String shopLink) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.shopUrl = shopLink;

    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getShopUrl() {
        return shopUrl;
    }

}