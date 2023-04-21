package main.java.com.solvd.farm.employee;

public class FieldEmployee extends Employee {

    private boolean driverLicence;

    public FieldEmployee(String name, String emailAddress, long phoneNumber, int employeeID, boolean driverLicence) {
        super(name, emailAddress, phoneNumber, employeeID);
    }

    @Override
    public void employeeDetails() {
        System.out.println("The employee name: " + name + "\nEmployee ID: " + employeeID + "\nPhone Number: " + phoneNumber);

    }

}
