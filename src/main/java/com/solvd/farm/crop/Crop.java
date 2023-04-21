package main.java.com.solvd.farm.crop;

public abstract class Crop {
    protected int price;
    protected String name;

    public Crop(String name, int price) {
        this.price = price;
        this.name = name;
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
}

