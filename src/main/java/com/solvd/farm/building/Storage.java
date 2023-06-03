package com.solvd.farm.building;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Storage extends Building {
    private static final Logger logger = LogManager.getLogger(Storage.class);
    private String type;
    public final int desiredTemp = 30;

    public Storage(String buildingName, String headOfDepartment, int capacity, String type) {
        super(buildingName, headOfDepartment, capacity);
        this.type = type;
    }

    public int getDesiredTemp() {
        return desiredTemp;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void nameOfHeadDepartment() {
        logger.info("The Building name: " + getBuildingName() + "\nHead Of Department: " + getHeadOfDepartment() + "\nBuilding capacity: " + getCapacity());
    }

    @Override
    public void setTemperature(int currentTemp) {
        if (currentTemp < desiredTemp) {
            logger.info("Temperature is lower than desired");
        } else if (currentTemp > desiredTemp) {
            logger.info("Temperature is higher than desired");
        } else {
            logger.info("Temperature is perfect!");
        }
    }

}

