package com.solvd.farm.building;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Storage extends Building implements ITemperatureControl {
    private String type;
    public final int desiredTemp = 30;
    public static double currentTemp;

    public Storage(String buildingName, String headOfDepartment, int capacity, String type) {
        super(buildingName, headOfDepartment, capacity);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private static Logger logger = LogManager.getLogger(Storage.class);

    @Override
    public void nameOfHeadDepartment() {
        logger.info("The Building name: " + getBuildingName() + "\nHead Of Department: " + getHeadOfDepartment() + "\nBuilding capacity: " + getCapacity());
    }

    @Override
    public void controlTemperature() {
        if (currentTemp < desiredTemp) {
            logger.info("temperature is already at desired level");
        } else if (currentTemp > desiredTemp) {
            logger.info("temperature is already at desired level");
        } else {
            logger.info("temperature is already at desired level");
        }
    }

}

