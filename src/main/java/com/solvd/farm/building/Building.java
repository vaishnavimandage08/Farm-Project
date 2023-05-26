package com.solvd.farm.building;

public abstract class Building implements ITemperatureControl {
    private String buildingName;
    private String headOfDepartment;
    private int Capacity;
    public boolean locked;

    public Building(String buildingName, String headOfDepartment, int capacity) {
        this.buildingName = buildingName;
        this.headOfDepartment = headOfDepartment;
        this.Capacity = capacity;
    }
    public String getBuildingName() {
        return buildingName;
    }

    public String getHeadOfDepartment() {
        return headOfDepartment;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public abstract void nameOfHeadDepartment();
}
