package com.solvd.farm;

import com.solvd.farm.crop.Crop;
import com.solvd.farm.exception.ItemNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class CropProductionManager {
    private ArrayList<Crop> cropList = new ArrayList<>();

    public void addCrop(Crop crop) {
        cropList.add(crop);
    }

    private static Logger logger = LogManager.getLogger(CropProductionManager.class);

    public Crop searchCrop(String product) throws ItemNotFoundException {
        logger.debug("finding a product");
        for (Crop crop : cropList) {
            if (crop.getName().equals(product)) {
                return crop;
            }
        }
        throw new ItemNotFoundException("Item not found: " + product);
    }

    public void displayCrop() {
        int size = cropList.size();
        for (Crop crop : cropList) {
            logger.info("Name: " + crop.getName());
            logger.info(crop.getPrice());
            crop.reportRevenue();
            logger.info("--------------------");
        }
    }
}
