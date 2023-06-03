package com.solvd.farm;

import com.solvd.farm.enums.FarmHours;
import com.solvd.farm.exception.InvalidChoiceException;
import com.solvd.farm.exception.ItemNotFoundException;
import com.solvd.farm.exception.UserNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws UserNotFoundException, ItemNotFoundException {
        EmployeeManager employeeManager = new EmployeeManager(ApplicationDataGenerator.generateEmployee());
        BuildingManager buildingManager = new BuildingManager(ApplicationDataGenerator.generateBuilding());
        ProductManager productManager = null;

        try {
            productManager = new ProductManager(ApplicationDataGenerator.generateCrop(), ApplicationDataGenerator.generateDairy(), ApplicationDataGenerator.generateVegetable());
        } catch (Exception exception) {
            logger.error("Failed to load application data. " + exception);
        }

        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            logger.info("\n" +
                    "╔════════════════════════════════╗\n" +
                    "║       Welcome to our Farm!     ║\n" +
                    "╠════════════════════════════════╣\n" +
                    "║ 1. Access Employee Portal      ║\n" +
                    "║ 2. Access Customer Portal      ║\n" +
                    "║ 3. Farm Buildings              ║\n" +
                    "║ 4. Farm Hours                  ║\n" +
                    "║ 0. Exit                        ║\n" +
                    "╚════════════════════════════════╝\n" +
                    "\n" +
                    "Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            try {
                switch (choice) {
                    case 1:
                        employeeManager.displayEmployeePortal();
                        break;
                    case 2:
                        productManager.displayProductPortal();
                        break;
                    case 3:
                        buildingManager.displayBuildingPortal();
                        break;
                    case 4:
                        Stream.of(FarmHours.values())
                                .map(hours -> "day: " + hours.name()
                                        + "\n║ open: " + hours.getOpeningTime()
                                        + "\n║ close: " + hours.getClosingTime())
                                .forEach(hoursInfo -> logger.info("\n║ " + hoursInfo));
                        break;
                    case 0:
                        break;
                    default:
                        throw new InvalidChoiceException("Invalid choice. Please try again.");
                }
            } catch (InvalidChoiceException | InputMismatchException e) {
                logger.info(e.getMessage());
            }
        }
    }
}