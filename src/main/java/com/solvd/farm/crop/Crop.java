package main.java.com.solvd.farm.crop;

public abstract class Crop implements ISales {
    protected int price;
    protected String name;
    protected final double expectedRevenue = 2000;
    protected double realizedRevenue;

    public double getRealizedRevenue() {
        return realizedRevenue;
    }

    public Crop(String name, int price, double realizedRevenue) {
        this.price = price;
        this.name = name;
        this.realizedRevenue = realizedRevenue;
    }

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
}

