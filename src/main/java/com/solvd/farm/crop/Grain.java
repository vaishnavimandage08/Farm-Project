package main.java.com.solvd.farm.crop;

public class Grain extends Crop{
    private String uses;
    private String nutritionalValue;

    public Grain( String name,int price,String uses, String nutritionalValue) {
        super(name,price);
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
        System.out.println("The crop name: " + name
                + "\n price: " + price
                + "\nuses: " + nutritionalValue);
    }
}
