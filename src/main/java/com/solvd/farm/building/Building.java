package com.solvd.farm.building;

public abstract class Building  {
    private String buildingName;
    private String headOfDepartment;
    private int Capacity;
    public boolean locked;

    public void setLocked(boolean locked) {

        this.locked = locked;
    }
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

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public void setHeadOfDepartment(String headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public abstract void nameOfHeadDepartment();
}
