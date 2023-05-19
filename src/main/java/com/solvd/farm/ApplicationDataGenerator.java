package com.solvd.farm;

import com.solvd.farm.building.Barn;
import com.solvd.farm.building.Building;
import com.solvd.farm.building.Storage;
import com.solvd.farm.crop.Crop;
import com.solvd.farm.crop.Grain;
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
    public static ArrayList<Crop> generateCrop() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

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
        Class<Grain> grainClass = Grain.class;

        // Get the constructor of Crop with no arguments
        Constructor<Grain> constructor = grainClass.getConstructor(String.class, int.class, double.class, String.class);
        constructor.setAccessible(true);

        // Create a new instance of Crop using the constructor
        data.add(constructor.newInstance(
                "Corn",
                5,
                689,
                "Carbs"));

        return data;
    }

    public static ArrayList<DairyProduct> generateDairy() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
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

    public static ArrayList<Employee> generateEmployee() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
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

    public static ArrayList<Building> generateBuilding() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
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
}