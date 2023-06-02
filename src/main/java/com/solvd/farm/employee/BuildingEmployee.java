package com.solvd.farm.employee;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.LocalDateTime;

public class BuildingEmployee extends Employee {
    private static Logger logger = LogManager.getLogger(BuildingEmployee.class);

    private String department;

    public BuildingEmployee(String name, int employeeID, String emailAddress,  long phoneNumber) {
        super(name, emailAddress, phoneNumber, employeeID);
    }
    @Override
    public void employeeDetails() {
        logger.info("The employee name: " + getName() + "\nEmployee ID: " + getEmployeeID() + "\nPhone Number: " + getPhoneNumber());
    }

    @Override
    public void checkIn(LocalDateTime timeIn) {
//        this.setTimeIn(timeIn);
        consumer.accept(timeIn);
    }

    @Override
    public void checkOut(LocalDateTime timeOut) {
        this.setTimeOut(timeOut);
    }
}
