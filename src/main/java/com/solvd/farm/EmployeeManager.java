package com.solvd.farm;

import com.solvd.farm.employee.Employee;
import com.solvd.farm.exception.DuplicateEntryException;
import com.solvd.farm.exception.InvalidException;
import com.solvd.farm.exception.UserNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

public class EmployeeManager {
    private ArrayList<Employee> employeeList = new ArrayList<>();
    private static Logger logger = LogManager.getLogger(EmployeeManager.class);

    public void checkInEmployee(Employee employee) throws InvalidException, DuplicateEntryException {
        logger.debug("Checking in employee");
        if (employee.getName() == null) {
            throw new InvalidException("Name cannot be null");
        }
        boolean found = false;
        for (Employee e : employeeList) {
            if (e.getEmailAddress().equals(employee.getEmailAddress())) {
                found = true;
                break;
            }
        }
        if (found) {
            throw new DuplicateEntryException("Employee with email " + employee.getEmailAddress() + " already exists");
        } else {
            employee.checkIn();
            employeeList.add(employee);
        }
    }

    public Employee findUserByName(String name) throws UserNotFoundException {
        logger.debug("Finding user by name: {}", name);
        for (Employee employee : employeeList) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        throw new UserNotFoundException("User not found: " + name);
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
            logger.info("\nName: " + employee.getName() + "\nID:" + employee.getEmployeeID() + "\nPhone Number: " + employee.getPhoneNumber() + "\nEmail Address: " + employee.getEmailAddress() + "\nCheck in time: " + employee.getTimeIn() + "\nCheck out time: " + employee.getTimeOut());
            employee.addExtraHours();
            logger.info("--------------------");
        }
    }
}
