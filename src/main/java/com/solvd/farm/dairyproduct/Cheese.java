package com.solvd.farm.dairyproduct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cheese extends DairyProduct {
    private static final Logger logger = LogManager.getLogger(Cheese.class);
    private long expiryDate;

    public Cheese(String name,int price, double fatContent, long expiryDate) {
        super(price, fatContent, name);
        this.expiryDate = expiryDate;
    }
    public void setExpiryDate(long expiryDate) {
        this.expiryDate = expiryDate;
    }
    public long getExpiryDate() {
        return expiryDate;
    }
    @Override
    public void detailsOfProduct() {
        logger.info("The product name: " + getName() + "\nPrice: " + getPrice() + "\nFat content: " + getFatContent());
    }
}
