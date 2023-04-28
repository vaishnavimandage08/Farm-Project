package com.solvd.farm;

import com.solvd.farm.building.Barn;
import com.solvd.farm.building.Storage;
import com.solvd.farm.crop.Grain;
import com.solvd.farm.crop.Vegetable;
import com.solvd.farm.employee.BuildingEmployee;
import com.solvd.farm.employee.FieldEmployee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        try {
            FieldEmployee fieldEmployee = new FieldEmployee("John", "john123@gmail.com", 234532125, 124, true);
            BuildingEmployee buildingEmployee = new BuildingEmployee("jack", "jack123@gmail.com", "Building", 234532125, 200);
            employeeManager.checkInEmployee(fieldEmployee);
            employeeManager.checkInEmployee(buildingEmployee);
            fieldEmployee.setTotalHours(12);
            buildingEmployee.setTotalHours(10);
            employeeManager.displayEmployees();
            employeeManager.checkOutEmployee(fieldEmployee);
            employeeManager.checkOutEmployee(buildingEmployee);
            employeeManager.displayEmployees();
        } catch (Exception e) {
            logger.info("Error: " + e.getMessage());
        }

        try {
            FieldEmployee fieldEmployee = new FieldEmployee("John", "john123@gmail.com", 234532125, 124, true);
            employeeManager.checkInEmployee(fieldEmployee);
        } catch (Exception e) {
            logger.info("Error: " + e.getMessage());
        }
        try {
            employeeManager.findUserByName("John");
        } catch (Exception e) {
            logger.info("Error: " + e.getMessage());
        }

        CropProductionManager cropProductionManager = new CropProductionManager();
        Grain grain = new Grain("Wheat", 10, 689, "bread", "Protein");
        Vegetable vegetable = new Vegetable("Spinach", 5, 900.87, 10);
        cropProductionManager.addCrop(grain);
        cropProductionManager.addCrop(vegetable);
        cropProductionManager.displayCrop();
        try {
            cropProductionManager.searchCrop("Rice");
        } catch (Exception e) {
            logger.info("Error: " + e.getMessage());
        }

        BuildingManager buildingManager = new BuildingManager();
        Storage storage = new Storage("Agree", "Jonathan", 100, "cold");
        Barn barn = new Barn("Dairy barn", "Andrew", 50, true);
        storage.setLocked(true);
        barn.setLocked(false);
        buildingManager.displayBuilding();
        buildingManager.setTemperatureOfStorage(30);
        try {
            buildingManager.addBuilding(storage);
            buildingManager.addBuilding(barn);
        } catch (Exception e) {
            logger.info("Error: " + e.getMessage());
        }
    }
}
