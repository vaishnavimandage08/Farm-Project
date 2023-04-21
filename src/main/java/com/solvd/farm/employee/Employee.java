package main.java.com.solvd.farm.employee;

public abstract class Employee {
    protected String name;
    protected String emailAddress;
    protected String department;
    protected long phoneNumber;
    protected int employeeID;

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

    public String getDepartment() {
        return department;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public abstract void employeeDetails();

}
