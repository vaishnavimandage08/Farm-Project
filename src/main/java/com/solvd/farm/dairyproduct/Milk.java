package com.solvd.farm.dairyproduct;

import com.solvd.farm.BuildingManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Milk extends DairyProduct {
    private boolean pasteurized;

    public Milk(boolean pasteurized, int price, double fatContent, String name) {
        super(price, fatContent, name);
        this.pasteurized = pasteurized;
    }
    private static Logger logger = LogManager.getLogger(Milk.class);

    public void setPasteurized(boolean pasteurized) {
        this.pasteurized = pasteurized;
    }
    public boolean isPasteurized() {
        return pasteurized;
    }

    @Override
    public void detailsOfProduct() {
        logger.info("The product name: " + getName()
                + "\nPrice: " + getPrice()
                + "\nFat content: " + getFatContent()
        );

    }
}
