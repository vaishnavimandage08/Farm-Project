package com.solvd.farm.dairyproduct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Butter extends DairyProduct {
    private long expiryDate;
    public Butter(int price, double fatContent, String name, long expiryDate) {
        super(price, fatContent, name);
        this.expiryDate = expiryDate;
    }
    private static Logger logger = LogManager.getLogger(Butter.class);

    public long getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(long expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public void detailsOfProduct() {
        logger.info("The product name: " + getName() + "\nPrice: " + getPrice() + "\nFat content: " + getFatContent());
    }
}
