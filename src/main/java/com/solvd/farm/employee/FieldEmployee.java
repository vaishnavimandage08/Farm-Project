package main.java.com.solvd.farm.employee;

public class FieldEmployee extends Employee {

    private boolean driverLicence;
    public  int totalHours;

    public FieldEmployee(String name, String emailAddress, long phoneNumber, int employeeID, boolean driverLicence) {
        super(name, emailAddress, phoneNumber, employeeID);
    }
    @Override
    public void employeeDetails() {
        System.out.println("The employee name: " + name + "\nEmployee ID: " + employeeID + "\nPhone Number: " + phoneNumber);
    }
    @Override
    public void checkIn() {
        timeIn = System.currentTimeMillis();
    }

    @Override
    public void checkOut() {
        timeOut = System.currentTimeMillis();
    }

    @Override
    public void addExtraHours() {
        int extraHours = (totalHours - EXPECTED_HOURS);
        if (extraHours > 0) {
            System.out.println("Extra Hours " + extraHours);
        } else {
            System.out.println("No Extra Hours ");
        }
    }
}