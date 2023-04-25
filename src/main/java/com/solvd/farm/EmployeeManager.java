package main.java.com.solvd.farm;

import main.java.com.solvd.farm.building.Storage;
import main.java.com.solvd.farm.employee.BuildingEmployee;
import main.java.com.solvd.farm.employee.Employee;
import main.java.com.solvd.farm.employee.FieldEmployee;

import java.util.ArrayList;

public class EmployeeManager {
    ArrayList<Employee> employeeList = new ArrayList<>();

    public void checkInEmployee(Employee employee) {
        employee.checkIn();
        employeeList.add(employee);
    }

    public void checkOutEmployee(Employee employee) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).equals(employee)) {
                employeeList.get(i).checkOut();
            }
        }
    }

    public void displayEmployees() {
        int size = employeeList.size();
        for (int i = 0; i < size; i++) {
            Employee employee = employeeList.get(i);
            System.out.println("Name: " + employee.getName());
            System.out.println("ID: " + employee.getEmployeeID());
            System.out.println("Phone Number: " + employee.getPhoneNumber());
            System.out.println("Email Address: " + employee.getEmailAddress());
            System.out.println("Check in time: " + employee.getTimeIn());
            System.out.println("Check out time: " + employee.getTimeOut());
            employee.addExtraHours();
            System.out.println("--------------------");
        }
    }
}
