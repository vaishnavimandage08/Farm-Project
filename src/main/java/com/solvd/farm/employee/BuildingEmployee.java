package main.java.com.solvd.farm.employee;

import main.java.com.solvd.farm.employee.Employee;

public class BuildingEmployee extends Employee {
    private String department;
    public BuildingEmployee(String name, String emailAddress, String department, long phoneNumber, int employeeID) {
        super(name,emailAddress, phoneNumber,employeeID);
    }

    @Override
    public void employeeDetails() {
        System.out.println("The employee name: " + emailAddress
                + "\nEmployee ID: " + employeeID
                + "\nPhone Number: " + phoneNumber);
    }
}
