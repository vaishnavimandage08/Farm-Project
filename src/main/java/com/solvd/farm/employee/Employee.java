package com.solvd.farm.employee;

import java.time.LocalDateTime;
import java.util.function.Consumer;

public abstract class Employee implements ILogin, IExtraWorkingHours {
    private String name;
    private String emailAddress;
    private long phoneNumber;
    private int employeeID;
    private LocalDateTime timeIn;
    private LocalDateTime timeOut;
    protected final int EXPECTED_HOURS = 6;
    public static int totalHours;

    public Employee(String name, String emailAddress, long phoneNumber, int employeeID) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.employeeID = employeeID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setTotalHours(int hours) {
        this.totalHours = hours;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public abstract void employeeDetails();

//    public void setTimeIn(LocalDateTime timeIn) {
//        this.timeIn = timeIn;
//    }

    // Consumer Interface
    public Consumer<LocalDateTime> consumer = (timeIn) -> {
        this.timeIn = timeIn;
    };

    public LocalDateTime getTimeIn() {
        return timeIn;
    }

    public void setTimeOut(LocalDateTime timeOut) {
        this.timeOut = timeOut;
    }

    public LocalDateTime getTimeOut() {
        return timeOut;
    }

}
