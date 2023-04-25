package main.java.com.solvd.farm;

import main.java.com.solvd.farm.building.Building;
import main.java.com.solvd.farm.building.Storage;
import main.java.com.solvd.farm.employee.Employee;

import java.util.ArrayList;
public class BuildingManager {
    ArrayList<Building> buildingList = new ArrayList<>();

    public void addBuilding(Building building) {
        buildingList.add(building);
    }
    public void setTemperatureOfStorage(int i) {
        Storage.currentTemp = i;
    }

    public void displayBuilding() {
        int size = buildingList.size();
        for (int i = 0; i < size; i++) {
            Building building = buildingList.get(i);
            System.out.println("Name: " + building.getBuildingName());
            System.out.println("Head Of Department: " + building.getHeadOfDepartment());
            if (building instanceof Storage) {
                ((Storage) building).controlTemperature();
            }
            building.lock();
            System.out.println("--------------------");
        }
    }
}
