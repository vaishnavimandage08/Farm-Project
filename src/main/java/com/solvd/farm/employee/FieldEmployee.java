package com.solvd.farm.employee;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FieldEmployee extends Employee {
    private boolean driverLicence;
    public int totalHours;
    public FieldEmployee(String name, String emailAddress, long phoneNumber, int employeeID, boolean driverLicence) {
        super(name, emailAddress, phoneNumber, employeeID);
    }
    private static Logger logger = LogManager.getLogger(FieldEmployee.class);
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
            logger.info("No Extra Hours ");
        }
    }
}