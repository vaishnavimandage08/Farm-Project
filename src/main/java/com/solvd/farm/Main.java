package com.solvd.farm;

import com.solvd.farm.enums.FarmHours;
import com.solvd.farm.exception.InvalidChoiceException;
import com.solvd.farm.exception.ItemNotFoundException;
import com.solvd.farm.exception.UserNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws UserNotFoundException, ItemNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        EmployeeManager employeeManager = new EmployeeManager(ApplicationDataGenerator.generateEmployee());
        BuildingManager buildingManager = new BuildingManager(ApplicationDataGenerator.generateBuilding());
        ProductManager productManager = null;

        try {
            productManager = new ProductManager(ApplicationDataGenerator.generateCrop(), ApplicationDataGenerator.generateDairy());
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
                    "║ 3. Farm Status                 ║\n" +
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
                        for (FarmHours hours : FarmHours.values()){
                            String day = hours.name();
                            String openingTime = hours.getOpeningTime();
                            String closingTime = hours.getClosingTime();

                            logger.info("║ " + day + ": " + openingTime + " - " + closingTime);
                        }
                        break;
                    case 0:
                        break;
                    default:
                        throw new InvalidChoiceException("Invalid choice. Please try again.");
                }
            } catch (InvalidChoiceException e) {
                logger.info(e.getMessage());
            }
        }
    }
}