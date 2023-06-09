package com.solvd.farm.dairyproduct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Milk extends DairyProduct {

    private static final Logger logger = LogManager.getLogger(Milk.class);
    private boolean pasteurized;

    public Milk(String type, boolean pasteurized, int price, double fatContent) {
        super(price, fatContent, type);
        this.pasteurized = pasteurized;
    }

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
