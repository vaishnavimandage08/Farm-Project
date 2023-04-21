package main.java.com.solvd.farm.dairyproduct;

public class Milk extends DairyProduct {
    private long expiryDate;
    private boolean pasteurized;

    public Milk(long expiryDate, boolean pasteurized, int price, double fatContent, String name) {
        super(price,fatContent,name);
        this.expiryDate = expiryDate;
        this.pasteurized = pasteurized;
    }

    public void setExpiryDate(int expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setPasteurized(boolean pasteurized) {
        this.pasteurized = pasteurized;
    }

    public boolean isPasteurized() {
        return pasteurized;
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
