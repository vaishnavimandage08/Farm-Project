package com.solvd.farm;

import com.solvd.farm.employee.Employee;
import com.solvd.farm.exception.UserNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EmployeeManager  {
    private static final Logger logger = LogManager.getLogger(EmployeeManager.class);
    private  ArrayList<Employee> employeeList;

    public EmployeeManager(ArrayList<Employee> employee) {
        employeeList = employee;
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
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
                    "║ 3. Display Employee List       ║\n" +
                    "║ 0. Back to Main Menu           ║\n" +
                    "╚════════════════════════════════╝\n" +
                    "Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    logger.info("Enter your employee ID: ");
                    int inputId = scanner.nextInt();

                    boolean employeeFound = employeeList.stream()
                            .anyMatch(employee -> employee.employeeFinder.test(inputId));

                    if (employeeFound) {
                        Employee foundEmployee = employeeList.stream()
                                .filter(employee -> employee.employeeFinder.test(inputId))
                                .findFirst()
                                .orElseThrow(() -> new UserNotFoundException("Error: Employee ID not found."));

                        foundEmployee.checkIn(LocalDateTime.now());
                        logger.info("Check In Done!");
                    } else {
                        logger.info("Error: Employee ID not found.");
                        logger.debug("Please try again or enter '0' to return to the main menu.");
                    }

                    break;
                case 2: {
                    logger.info("Enter your employee ID: ");
                    int inputId1 = scanner.nextInt();
                    employeeList.forEach(employee -> {
                        if (employee.getEmployeeID() == inputId1) {
                            employee.checkOut(LocalDateTime.now());
                            logger.info("You have successfully checked out!");
                            long dif = ChronoUnit.MINUTES.between(employee.getTimeOut(), employee.getTimeIn());
                            if (dif < 0)
                                dif += 24 * 60; // Add 24 hours in minutes
                            long sumHour = dif / 60;
                            long sumMinute = dif % 60;
                            logger.info("Total hours worked: " + sumHour + ":" + sumMinute);
                        }
                    });
                }
                    break;
                case 3:
                    String list = employeeList.stream()
                            .map(employee -> employee.getEmployeeID() + "  " + employee.getName())
                            .collect(Collectors.joining("\n"));

                    if (!list.equals("")) {
                        list = "\n" + "id   " + "name"
                                + "\n----------"
                                + "\n" + list;
                        logger.info(list);
                    }
                    break;
                case 0:
                    break;
                default:
                    logger.info("Invalid choice. Please try again.");
            }
        }
    }
}


