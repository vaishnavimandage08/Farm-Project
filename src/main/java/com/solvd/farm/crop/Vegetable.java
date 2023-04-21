package main.java.com.solvd.farm.crop;

public class Vegetable extends Crop {
    private int maturityTimeInDays;

    public Vegetable(String name, int price, int maturityTimeInDays) {
        super(name, price);
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
        System.out.println("The crop name: " + name + "\n price: " + price + "\nuses: " + maturityTimeInDays);
    }
}
