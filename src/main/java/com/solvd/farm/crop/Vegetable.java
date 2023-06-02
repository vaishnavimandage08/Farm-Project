package com.solvd.farm.crop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Vegetable extends Crop {
    private static Logger logger = LogManager.getLogger(Vegetable.class);
    private int maturityTimeInDays;
    public Vegetable(String name, int price, double realizedRevenue, int maturityTimeInDays) {
        super(name, price, realizedRevenue);
        this.maturityTimeInDays = maturityTimeInDays;
    }
    public void setMaturityTimeInDays(int maturityTimeInDays) {
        this.maturityTimeInDays = maturityTimeInDays;
    }

    public int getMaturityTimeInDays() {
        return maturityTimeInDays;
    }

    @Override
    public void nameOfCrops() {
        logger.info("The crop name: " + getName() + "\n price: " + getPrice() + "\nuses: " + maturityTimeInDays);
    }

}
