package com.solvd.farm.dairyproduct;

import com.solvd.farm.IEqualIgnore;

public abstract class DairyProduct {
    private int price;
    private double fatContent;
    private String name;

    public DairyProduct(int price, double fatContent, String name) {
        this.price = price;
        this.fatContent = fatContent;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public double getFatContent() {
        return fatContent;
    }

    public void setPrice(int quantity) {
        this.price = price;
    }

    public void setFatContent(double fatContent) {
        this.fatContent = fatContent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public IEqualIgnore isEqual = name -> this.name.equalsIgnoreCase(name);

    public abstract void detailsOfProduct();

}

