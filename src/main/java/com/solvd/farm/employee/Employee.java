package main.java.com.solvd.farm.employee;

public abstract class Employee implements ILogin, IExtraWorkingHours {
    protected String name;
    protected String emailAddress;
    protected String department;
    protected long phoneNumber;
    protected int employeeID;
    protected long timeIn;
    protected long timeOut;

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

    public String getDepartment() {
        return department;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public static int getTotalHours() {
        return totalHours;
    }
    public void setTotalHours(int hours) {
        this.totalHours = hours;
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

    public long getTimeIn() {
        return timeIn;
    }

    public long getTimeOut() {
        return timeOut;
    }

}
