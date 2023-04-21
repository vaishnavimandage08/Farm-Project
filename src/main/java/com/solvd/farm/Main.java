package main.java.com.solvd.farm;

import main.java.com.solvd.farm.building.Barn;
import main.java.com.solvd.farm.building.Storage;
import main.java.com.solvd.farm.crop.Grain;
import main.java.com.solvd.farm.crop.Vegetable;
import main.java.com.solvd.farm.employee.BuildingEmployee;
import main.java.com.solvd.farm.employee.FieldEmployee;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        FieldEmployee fieldEmployee = new FieldEmployee("john", "john123@gmail.com", 234532125, 124, true);
        BuildingEmployee buildingEmployee = new BuildingEmployee("jack", "john123@gmail.com", "Building", 234532125, 200);
        employeeManager.addEmployee(fieldEmployee);
        employeeManager.addEmployee(buildingEmployee);
        employeeManager.displayEmployees();

        CropProductionManager cropProductionManager = new CropProductionManager();
        Grain grain = new Grain("Wheat", 10, "bread", "Protein");
        Vegetable vegetable = new Vegetable("Spinach", 5, 15);
        cropProductionManager.addCrop(grain);
        cropProductionManager.addCrop(vegetable);
        cropProductionManager.displayCrop();

        BuildingManager buildingManager = new BuildingManager();
        Storage storage = new Storage("Agree", "Jonathan", 100, "cold");
        Barn barn = new Barn("Dairy barn", "Perceive", 50, true);
        buildingManager.addBuilding(storage);
        buildingManager.addBuilding(barn);
        buildingManager.displayBuilding();

    }
}
