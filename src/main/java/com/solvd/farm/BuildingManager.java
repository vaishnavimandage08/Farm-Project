package main.java.com.solvd.farm;

import main.java.com.solvd.farm.building.Building;
import main.java.com.solvd.farm.employee.Employee;

import java.util.ArrayList;

public class BuildingManager {
    ArrayList<Building> buildingList = new ArrayList<>();

    public void addBuilding(Building building) {
        buildingList.add(building);
    }

    public void displayBuilding() {
        int size = buildingList.size();
        for (int i = 0; i < size; i++) {
            Building building = buildingList.get(i);
            System.out.println("Name: " + building.getBuildingName());
            System.out.println("Head Of Department: " + building.getHeadOfDepartment());
            System.out.println("capacity: " + building.getCapacity());
            System.out.println("--------------------");
        }
    }
}
