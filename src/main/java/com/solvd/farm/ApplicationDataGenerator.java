package com.solvd.farm;

import com.solvd.farm.building.Barn;
import com.solvd.farm.building.Building;
import com.solvd.farm.building.Storage;
import com.solvd.farm.crop.Crop;
import com.solvd.farm.crop.Grain;
import com.solvd.farm.crop.Vegetable;
import com.solvd.farm.dairyproduct.Butter;
import com.solvd.farm.dairyproduct.Cheese;
import com.solvd.farm.dairyproduct.DairyProduct;
import com.solvd.farm.dairyproduct.Milk;
import com.solvd.farm.employee.BuildingEmployee;
import com.solvd.farm.employee.Employee;
import com.solvd.farm.employee.FieldEmployee;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class ApplicationDataGenerator {
    public static ArrayList<Crop> generateCrop() throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {

        ArrayList<Crop> data = new ArrayList<>();
        data.add(new Grain(
                "Wheat",
                10,
                689,
                "Protein"));
        data.add(new Grain(
                "Rice",
                15,
                700,
                "Protein"));

        // Generate data using reflection
        // create an object of Grain Class

        Class<Grain> grainClass = Grain.class;

        // Get the constructor of Grain with arguments
        Constructor<Grain> constructor = grainClass.getConstructor(String.class, int.class, double.class, String.class);

        // allow modification of the private field
        constructor.setAccessible(true);

        // Create a new instance of Grain using the constructor and then added to a data collection or list.
        data.add(constructor.newInstance(
                "Corn",
                5,
                689,
                "Carbs"));

        return data;
    }

    public static ArrayList<DairyProduct> generateDairy() {
        ArrayList<DairyProduct> data = new ArrayList<>();
        Butter butter = new Butter(
                "Salted Butter",
                5,
                12,
                10 / 02 / 2023);
        data.add(butter);

        Milk milk = new Milk(
                "Cow Milk",
                true,
                8,
                10);
        data.add(milk);

        Cheese cheese = new Cheese(
                "Cheddar Cheese",
                12,
                15,
                05 / 20 / 2023);
        data.add(cheese);

        return data;
    }

    public static ArrayList<Employee> generateEmployee() {
        ArrayList<Employee> data = new ArrayList<>();
        FieldEmployee fieldEmployee = new FieldEmployee(
                "John",
                125,
                "john123@gmail.com",
                234532125
        );
        data.add(fieldEmployee);

        fieldEmployee = new FieldEmployee(
                "Taylor",
                121,
                "taylor764@gmail.com",
                358902344);
        data.add(fieldEmployee);

        BuildingEmployee buildingEmployee =
                new BuildingEmployee("jack",
                        123,
                        "jack123@gmail.com",
                        234532125);
        data.add(buildingEmployee);
        return data;
    }

    public static ArrayList<Building> generateBuilding() {
        ArrayList<Building> data = new ArrayList<>();
        Storage storage = new Storage(
                "Grain bin",
                "Jonathan",
                100,
                "cold");
        data.add(storage);

        Barn barn = new Barn(
                "Dairy barn",
                "Andrew",
                50,
                true);
        storage.setLocked(true);
        barn.setLocked(false);
        data.add(barn);
        return data;
    }
    public static ArrayList<Vegetable> generateVegetable() {
        ArrayList<Vegetable> data = new ArrayList<>();
        Vegetable vegetable = new Vegetable(
                "Spinach",
                2,
                200,
                6);
        data.add(vegetable);

         vegetable = new Vegetable(
                "Broccoli",
                3,
                100,
                4);
        data.add(vegetable);
        return data;
    }
}