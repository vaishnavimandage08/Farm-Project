package com.solvd.farm;

import com.solvd.farm.crop.Crop;
import com.solvd.farm.crop.Grain;
import com.solvd.farm.crop.Vegetable;
import com.solvd.farm.exception.ItemNotFoundException;
import com.solvd.farm.exception.NullValueException;
import com.solvd.farm.exception.UserNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;

public class CropProductionManager {
    private static Logger logger = LogManager.getLogger(CropProductionManager.class);
    private ArrayList<Crop> cropList = new ArrayList<>();

    public CropProductionManager() {
        loadData();
    }

    public void displayCustomerPortal() throws ItemNotFoundException {
        LinkedList<Crop> cart = new LinkedList<Crop>();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            logger.info("\n"
                    + "╔════════════════════════════════╗\n"
                    + "║          Customer Portal       ║\n"
                    + "╠════════════════════════════════╣\n"
                    + "║ 1. Browse products             ║\n"
                    + "║ 2. Add to cart                 ║\n"
                    + "║ 3. Checkout process            ║\n"
                    + "║ 0. Back to Main Menu           ║\n"
                    + "╚════════════════════════════════╝\n"
                    + "\nEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Available Products : ");
                    System.out.println("--------------------");
                    for (Crop crop : cropList) {
                        logger.info("Name" + " " + crop.getName() + "\n" + "Price" + " " + crop.getPrice() + "$");
                        logger.info("--------------------");
                    }
                    break;
                case 2:
                    System.out.print("Enter the product: ");
                    String productName = scanner.nextLine();

                    for (Crop crop : cropList) {
                        if (crop.getName().equalsIgnoreCase(productName)) {
                            cart.insertAtEnD(crop);
                            logger.info(productName + " added to the cart.");
                            break;
                        }
                    }
                    try {
                        if (cart.isEmpty()) {
                            throw new UserNotFoundException("Error: Product not found..");
                        }
                    } catch (UserNotFoundException e) {
                        logger.info("Error: Product not found..");
                    }
                    break;
                case 3:
                    logger.info("Checkout process:");
                {
                    double totalPrice = 0.0;
                    int index = 0;
                    while (index < cart.size()) {
                        try {
                            Crop crop = cart.get(index);
                            totalPrice += crop.getPrice();
                        } catch (NullValueException e) {
                            logger.info(" Invalid Index");
                        }
                        index++;
                    }
                    logger.info("Total Price: " + totalPrice);
                    cart.clear();
                }
                break;
                case 0:
                    break;
                default:
                    logger.info("Invalid choice. Please try again.");
            }
        }
    }

    private void loadData() {

        cropList.add(new Grain(
                "Wheat",
                10,
                689,
                "Protein"));
        cropList.add(new Grain(
                "Rice",
                15,
                700,
                "Protein"));
        Vegetable vegetable = new Vegetable(
                "Spinach",
                5,
                900.87,
                10);
        cropList.add(vegetable);
    }
}
