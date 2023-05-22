package com.solvd.farm.building;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Barn extends Building {
    private boolean isClean;

    public Barn(String buildingName, String headOfDepartment, int capacity, boolean isClean) {
        super(buildingName, headOfDepartment, capacity);
        this.isClean = isClean;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }

    private static Logger logger = LogManager.getLogger(Barn.class);

    @Override
    public void nameOfHeadDepartment() {
        logger.info("The Building name: " + getBuildingName() + "\nHead Of Department: " + getHeadOfDepartment() + "\nBuilding capacity: " + getCapacity());
    }


}
