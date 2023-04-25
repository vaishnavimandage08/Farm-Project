package main.java.com.solvd.farm.crop;

public class Grain extends Crop {
    private String uses;
    private String nutritionalValue;

    public Grain(String name, int price, double realizedRevenue, String uses, String nutritionalValue) {
        super(name, price, realizedRevenue);
        this.uses = uses;
        this.nutritionalValue = nutritionalValue;
    }

    public String getUses() {
        return uses;
    }

    public String getNutritionalValue() {
        return nutritionalValue;
    }

    public void setUses(String uses) {
        this.uses = uses;
    }

    public void setNutritionalValue(String nutritionalValue) {
        this.nutritionalValue = nutritionalValue;
    }

    @Override
    public void nameOfCrops() {
        System.out.println("The crop name: " + name + "\n price: " + price + "\nuses: " + nutritionalValue);
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
