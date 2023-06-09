package com.solvd.farm.employee;

import com.solvd.farm.IEmployeeFinder;
import com.solvd.farm.IEqualIgnore;

import java.time.LocalDateTime;
import java.util.function.Consumer;

public abstract class Employee implements ILogin {
    private String name;
    private String emailAddress;
    private long phoneNumber;
    private int employeeID;
    private LocalDateTime timeIn;
    private LocalDateTime timeOut;
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

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setTotalHours(int hours) {
        this.totalHours = hours;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public abstract void employeeDetails();

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
    
    public IEmployeeFinder employeeFinder = empID -> this.employeeID==(empID);

}
