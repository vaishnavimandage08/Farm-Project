package main.java.com.solvd.farm.building;
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

    @Override
    public void nameOfHeadDepartment() {
        System.out.println("The Building name: " + buildingName + "\nHead Of Department: " + headOfDepartment + "\nBuilding capacity: " + Capacity);
    }
    @Override
    public void controlTemperature() {
        if (currentTemp < desiredTemp) {
            System.out.println("temperature is already at desired level");
        } else if (currentTemp > desiredTemp) {
            System.out.println("temperature is already at desired level");

        } else {
            System.out.println("temperature is already at desired level");
        }
    }
    @Override
    public void lock() {
        if (locked) System.out.println("locked");
        else {
            System.out.println("unlocked");

        }
    }
}

