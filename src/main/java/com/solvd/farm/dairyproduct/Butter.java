package main.java.com.solvd.farm.dairyproduct;

public class Butter extends DairyProduct {
    private long expiryDate;
    private double fatContent;

    public Butter(int price, double fatContent, String name, long expiryDate) {
        super(price, fatContent, name);
        this.expiryDate = expiryDate;
    }

    public long getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(long expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public void detailsOfProduct() {
//        System.out.println("The product name: " + DairyProduct.getName()
//                + "\nPrice: " + DairyProduct.getPrice()
//                + "\nFat content: " + DairyProduct.getFatcontent()
//        );
    }
}
