package com.solvd.farm;
import com.solvd.farm.exception.InvalidChoiceException;
import com.solvd.farm.exception.ItemNotFoundException;
import com.solvd.farm.exception.UserNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws UserNotFoundException, ItemNotFoundException, InvalidChoiceException {
        EmployeeManager employeeManager = new EmployeeManager();
        CropProductionManager cropProductionManager = new CropProductionManager();

        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            logger.info("\n" +
                    "╔════════════════════════════════╗\n" +
                    "║       Welcome to our Farm!     ║\n" +
                    "╠════════════════════════════════╣\n" +
                    "║ 1. Access employee portal      ║\n" +
                    "║ 2. Access customer portal      ║\n" +
                    "║ 0. Back to main menu           ║\n" +
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
                        cropProductionManager.displayCustomerPortal();
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