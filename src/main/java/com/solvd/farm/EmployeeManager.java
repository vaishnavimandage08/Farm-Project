package com.solvd.farm;

import com.solvd.farm.employee.BuildingEmployee;
import com.solvd.farm.employee.Employee;
import com.solvd.farm.employee.FieldEmployee;
import com.solvd.farm.exception.UserNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {
    private static final Logger logger = LogManager.getLogger(EmployeeManager.class);
    private final ArrayList<Employee> employeeList = new ArrayList<>();
    public EmployeeManager() {
        loadData();
    }

    public void displayEmployeePortal() throws UserNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            logger.info("\n" +
                    "╔════════════════════════════════╗\n" +
                    "║          Employee Portal       ║\n" +
                    "╠════════════════════════════════╣\n" +
                    "║ 1. Check in                    ║\n" +
                    "║ 2. Check out                   ║\n" +
                    "║ 0. Back to Main Menu           ║\n" +
                    "╚════════════════════════════════╝\n" +
                    "Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    logger.info("Enter your employee ID: ");
                    int inputId = scanner.nextInt();
                    boolean employeeFound = false;
                    for (Employee employee : employeeList) {
                        if (employee.getEmployeeID() == inputId) {
                            employee.setTimeIn(LocalDateTime.now());
                            employeeFound = true;
                            logger.info("Check In Done!");
                            break;
                        }
                    }
                    try {
                        if (!employeeFound) {
                            throw new UserNotFoundException("Error: Employee ID not found.");
                        }
                    } catch (UserNotFoundException e) {
                        logger.info("Error: Employee ID not found.");
                        logger.debug("Please try again or enter '0' to return to the main menu.");
                    }
                    break;
                case 2: {
                    System.out.println("Enter your employee ID: ");
                    int inputId1 = scanner.nextInt();
                    for (Employee employee : employeeList) {
                        if (employee.getEmployeeID() == inputId1) {
                            employee.setTimeOut(LocalDateTime.now());
                            logger.info("You have successfully checked out!");
                            long dif = ChronoUnit.MINUTES.between(employee.getTimeOut(), employee.getTimeIn());
                            if (dif < 0)
                                dif += 24 * 60; // Add 24 hours in minutes
                            long sumHour = dif / 60;
                            long sumMinute = dif % 60;
                            logger.info("Total hours worked: " + sumHour + ":" + sumMinute);
                        }
                    }
                    break;
                }
                case 0:
                    break;
                default:
                    logger.info("Invalid choice. Please try again.");
            }
        }
    }
    private void loadData() {
        FieldEmployee fieldEmployee = new FieldEmployee(
                "John",
                125,
                "john123@gmail.com",
                234532125
        );
        employeeList.add(fieldEmployee);

        fieldEmployee = new FieldEmployee(
                "Taylor",
                121,
                "taylor764@gmail.com",
                358902344);
        employeeList.add(fieldEmployee);

        BuildingEmployee buildingEmployee = new BuildingEmployee("jack", 123, "jack123@gmail.com", 234532125);
        employeeList.add(buildingEmployee);
    }
}
