package main.java.com.solvd.farm;

import main.java.com.solvd.farm.employee.Employee;

import java.util.ArrayList;

public class EmployeeManager {
    ArrayList<Employee> employeeList = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void displayEmployees() {
        int size = employeeList.size();
        for (int i = 0; i < size; i++) {
            Employee employee = employeeList.get(i);
            System.out.println("Name: " + employee.getName());
            System.out.println("ID: " + employee.getEmployeeID());
            System.out.println("Phone Number: " + employee.getPhoneNumber());
            System.out.println("Phone Number: " + employee.getEmailAddress());
            System.out.println("--------------------");
        }
    }
}
