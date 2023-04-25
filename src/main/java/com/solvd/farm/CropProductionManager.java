package main.java.com.solvd.farm;

import main.java.com.solvd.farm.crop.Crop;

import java.util.ArrayList;

public class CropProductionManager {
    ArrayList<Crop> cropList = new ArrayList<>();

    public void addCrop(Crop crop) {
        cropList.add(crop);
    }
    public void displayCrop() {
        int size = cropList.size();
        for (int i = 0; i < size; i++) {
            Crop crop = cropList.get(i);
            System.out.println("Name: " + crop.getName());
            System.out.println("Price: " + crop.getPrice());
            crop.reportRevenue();
            System.out.println("--------------------");

        }
    }
}
