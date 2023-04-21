package main.java.com.solvd.farm.dairyproduct;

import main.java.com.solvd.farm.dairyproduct.DairyProduct;

public class Cheese extends DairyProduct {
    private double weight;
    private long expiryDate;

    public Cheese(int price, double fatContent, String name,long expiryDate) {
        super(price,fatContent,name);
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
//        System.out.println("The product name: " + DairyProduct.getName()
//                + "\nPrice: " + DairyProduct.getPrice()
//                + "\nFat content: " + DairyProduct.getFatcontent()
//        );
    }
}
