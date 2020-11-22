package com.bmsit.rentalapp.Model;

public class ProductDetailsClass {

    private int image;
    private String price;
    private String Name;

    public ProductDetailsClass() {
    }

    public ProductDetailsClass(int image, String price, String name) {
        this.image = image;
        this.price = price;
        Name = name;
    }

    public ProductDetailsClass(int image, String price) {
        this.image = image;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
