package com.solvd.farm;

import com.solvd.farm.building.Building;
import com.solvd.farm.building.Storage;
import com.solvd.farm.exception.NullValueException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

public class BuildingManager {
    private ArrayList<Building> buildingList = new ArrayList<>();

    public void addBuilding(Building building) throws NullValueException {
        if (building.getHeadOfDepartment() == null || building.getBuildingName() == null) {
            throw new NullValueException("Required fields cannot be null or 0");
        }
        buildingList.add(building);
    }
    public void setTemperatureOfStorage(int i) {
        Storage.currentTemp = i;
    }
    private static Logger logger = LogManager.getLogger(BuildingManager.class);
    public void displayBuilding() {
        int size = buildingList.size();
        for (int i = 0; i < size; i++) {
            Building building = buildingList.get(i);
            logger.info("Name: " + building.getBuildingName() + "\nHead Of Department: " + building.getHeadOfDepartment());
            if (building instanceof Storage) {
                ((Storage) building).controlTemperature();
            }
            building.lock();
            logger.info("--------------------");

        }
    }
}
