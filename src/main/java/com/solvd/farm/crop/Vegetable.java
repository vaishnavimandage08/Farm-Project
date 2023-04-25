package main.java.com.solvd.farm.crop;

public class Vegetable extends Crop {
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
        System.out.println("The crop name: " + name + "\n price: " + price + "\nuses: " + maturityTimeInDays);
    }

    @Override
    public void reportRevenue() {
        if (realizedRevenue > expectedRevenue) {
            System.out.println("Congratulations! You have made a profit of $" + (realizedRevenue - expectedRevenue));
        } else if (realizedRevenue < expectedRevenue) {
            System.out.println("Sorry! You have incurred a loss of $" + (expectedRevenue - realizedRevenue));
        }
    }
}
