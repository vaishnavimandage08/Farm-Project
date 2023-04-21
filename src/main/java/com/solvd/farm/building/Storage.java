package main.java.com.solvd.farm.building;

public class Storage extends Building{

    private String type;

    public Storage(String buildingName, String headOfDepartment, int capacity,String type ) {
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
        System.out.println("The Building name: " + buildingName
                + "\nHead Of Department: " + headOfDepartment
                + "\nBuilding capacity: " + Capacity);
    }
}
