package com.solvd.farm.employee;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BuildingEmployee extends Employee {
    private String department;

    public BuildingEmployee(String name, String emailAddress, String department, long phoneNumber, int employeeID) {
        super(name, emailAddress, phoneNumber, employeeID);
    }
    private static Logger logger = LogManager.getLogger(BuildingEmployee.class);
    @Override
    public void employeeDetails() {
        logger.info("The employee name: " + getName() + "\nEmployee ID: " + getEmployeeID() + "\nPhone Number: " + getPhoneNumber());
    }
    @Override
    public void checkIn() {
        setTimeIn(System.currentTimeMillis());
    }

    @Override
    public void checkOut() {
        setTimeOut(System.currentTimeMillis());
    }

    @Override
    public void addExtraHours() {
        int extraHours = (totalHours - EXPECTED_HOURS);
        if (extraHours > 0) {
            logger.info("Extra Hours " + extraHours);
        } else {
            logger.info("No Extra Hours");
        }
    }
}
