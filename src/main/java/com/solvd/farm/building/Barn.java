package main.java.com.solvd.farm.building;

public class Barn extends Building {
    private boolean isClean;

    public Barn(String buildingName, String headOfDepartment, int capacity, boolean isClean) {
        super(buildingName, headOfDepartment, capacity);
        this.isClean = isClean;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }

    @Override
    public void nameOfHeadDepartment() {
        System.out.println("The Building name: " + buildingName
                + "\nHead Of Department: " + headOfDepartment
                + "\nBuilding capacity: " + Capacity);

    }
}
