package com.solvd.farm.building;

public abstract class Building implements ITemperatureControl {
    private String buildingName;
    private String headOfDepartment;
    private int capacity;
    public boolean locked;

    public Building(String buildingName, String headOfDepartment, int capacity) {
        this.buildingName = buildingName;
        this.headOfDepartment = headOfDepartment;
        this.capacity = capacity;
    }
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
    public void setHeadOfDepartment(String headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public String getHeadOfDepartment() {
        return headOfDepartment;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isLocked() {
        return locked;
    }
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void setCapacity(int capacity) {
        capacity = capacity;
    }

    public abstract void nameOfHeadDepartment();
}
