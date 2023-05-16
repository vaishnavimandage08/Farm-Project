package com.solvd.farm.crop;

import java.util.Objects;
import java.util.function.Predicate;

public abstract class Crop implements ISales {
    private int price;
    private String name;
    protected final double expectedRevenue = 2000;
    private double realizedRevenue;

    public double getRealizedRevenue() {
        return realizedRevenue;
    }

    public Crop(String name, int price, double realizedRevenue) {
        this.price = price;
        this.name = name;
        this.realizedRevenue = realizedRevenue;
    }

    public Crop() {}

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void nameOfCrops();

    public void setRealizedRevenue(double realizedRevenue) {
        this.realizedRevenue = realizedRevenue;
    }

    public Predicate<String> isEqual = name -> this.name.equalsIgnoreCase(name);
}

