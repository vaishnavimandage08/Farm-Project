package com.solvd.farm.crop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Grain extends Crop {
    private static final Logger logger = LogManager.getLogger(Grain.class);
    private String nutritionalValue;

    public Grain(String name, int price, double realizedRevenue,  String nutritionalValue) {
        super(name, price, realizedRevenue);
        this.nutritionalValue = nutritionalValue;
    }

    public String getNutritionalValue() {
        return nutritionalValue;
    }

    public void setNutritionalValue(String nutritionalValue) {
        this.nutritionalValue = nutritionalValue;
    }

    @Override
    public void nameOfCrops() {
        logger.info("The crop name: " + getName() + "\n price: " + getPrice() + "\nuses: " + nutritionalValue);
    }

}
