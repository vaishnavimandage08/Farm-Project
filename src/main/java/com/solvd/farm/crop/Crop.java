package com.solvd.farm.crop;

import java.util.function.Predicate;

public abstract class Crop  {
    private int price;
    private String name;
    private double realizedRevenue;

    public Crop(String name, int price, double realizedRevenue) {
        this.price = price;
        this.name = name;
        this.realizedRevenue = realizedRevenue;
    }

    public Crop() {}

    public int getPrice() {
        return price;
    }
    public double getRealizedRevenue() {
        return realizedRevenue;
    }
    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setRealizedRevenue(double realizedRevenue) {
        this.realizedRevenue = realizedRevenue;
    }


    public abstract void nameOfCrops();

    public Predicate<String> isEqual = name -> this.name.equalsIgnoreCase(name);
}

