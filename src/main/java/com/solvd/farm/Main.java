package main.java.com.solvd.farm;

import main.java.com.solvd.farm.building.Barn;
import main.java.com.solvd.farm.building.Storage;
import main.java.com.solvd.farm.crop.Grain;
import main.java.com.solvd.farm.crop.Vegetable;
import main.java.com.solvd.farm.employee.BuildingEmployee;
import main.java.com.solvd.farm.employee.FieldEmployee;

public class Main {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        FieldEmployee fieldEmployee = new FieldEmployee("john", "john123@gmail.com", 234532125, 124, true);
        BuildingEmployee buildingEmployee = new BuildingEmployee("jack", "jack425@gmail.com", "Building", 234532125, 200);
        fieldEmployee.setTotalHours(12);
        buildingEmployee.setTotalHours(10);
        employeeManager.checkInEmployee(fieldEmployee);
        employeeManager.checkInEmployee(buildingEmployee);
        employeeManager.displayEmployees();
        employeeManager.checkOutEmployee(fieldEmployee);
        employeeManager.checkOutEmployee(buildingEmployee);
        employeeManager.displayEmployees();


        CropProductionManager cropProductionManager = new CropProductionManager();
        Grain grain = new Grain("Wheat", 10, 689, "bread", "Protein");
        Vegetable vegetable = new Vegetable("Spinach", 5, 900.87, 10);
        cropProductionManager.addCrop(grain);
        cropProductionManager.addCrop(vegetable);
        cropProductionManager.displayCrop();

        BuildingManager buildingManager = new BuildingManager();
        Storage storage = new Storage("Agree", "Jonathan", 100, "cold");
        Barn barn = new Barn("Dairy barn", "Andrew", 50, true);
        storage.setLocked(true);
        barn.setLocked(false);
        buildingManager.addBuilding(storage);
        buildingManager.addBuilding(barn);
        buildingManager.displayBuilding();
        buildingManager.setTemperatureOfStorage(30);
    }
}
