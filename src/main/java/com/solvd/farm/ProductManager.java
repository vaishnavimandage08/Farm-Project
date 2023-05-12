package com.solvd.farm;

import com.solvd.farm.crop.Crop;
import com.solvd.farm.crop.Grain;
import com.solvd.farm.crop.Vegetable;
import com.solvd.farm.dairyproduct.Butter;
import com.solvd.farm.dairyproduct.Cheese;
import com.solvd.farm.dairyproduct.DairyProduct;
import com.solvd.farm.dairyproduct.Milk;
import com.solvd.farm.exception.ItemNotFoundException;
import com.solvd.farm.exception.NullValueException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    private static final Logger logger = LogManager.getLogger(ProductManager.class);
    private final ArrayList<Crop> cropList = new ArrayList<>();
    private final ArrayList<DairyProduct> dairyProductList = new ArrayList<>();

    LinkedList<Crop> cropCart = new LinkedList<>();
    LinkedList<DairyProduct> dairyCart = new LinkedList<>();

    public ProductManager() {
        loadCropProducts();
        loadDairyProducts();
    }

    public void displayProductPortal() throws ItemNotFoundException {

        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            logger.info("\n"
                    + "╔════════════════════════════════╗\n"
                    + "║         Product Portal         ║\n"
                    + "╠════════════════════════════════╣\n"
                    + "║ 1. Browse products             ║\n"
                    + "║ 2. Display cart                ║\n"
                    + "║ 0. Back to Main Menu           ║\n"
                    + "╚════════════════════════════════╝\n"
                    + "\nEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    browseProducts();
                    break;
                case 2:
                    int index = 0;
                    String products = "";
                    while (index < cropCart.size()) {
                        try {
                            Crop crop = cropCart.get(index);
                            products += "\n" + crop.getName() + " -- " + "$" + crop.getPrice();
                        } catch (NullValueException e) {
                            logger.info(" Invalid Index");
                        }
                        index++;
                    }
                    index = 0;
                    while (index < dairyCart.size()) {
                        try {
                            DairyProduct dairyProduct = dairyCart.get(index);
                            products += "\n" + dairyProduct.getName() + " -- " + "$" + dairyProduct.getPrice();
                        } catch (NullValueException e) {
                            logger.info(" Invalid Index");
                        }
                        index++;
                    }
                    if (products.equals("")) {
                        logger.info("Cart is empty\n");
                    } else {
                        logger.info("\nCurrent products in your cart: \n" + products + "\n");
                    }
                    break;
                case 0:
                    break;
                default:
                    logger.info("Invalid choice. Please try again.");
            }
        }
    }

    private void browseProducts() {
        Scanner scanner = new Scanner(System.in);
        int productChoice = -1;
        while (productChoice != 0) {
            logger.info("\n"
                    + "╔════════════════════════════════╗\n"
                    + "║         Shop Products          ║\n"
                    + "╠════════════════════════════════╣\n"
                    + "║ 1. Crop Products               ║\n"
                    + "║ 2. Dairy Products              ║\n"
                    + "║ 3. Add to cart                 ║\n"
                    + "║ 4. Checkout process            ║\n"
                    + "║ 0. Back to Main Menu           ║\n"
                    + "╚════════════════════════════════╝\n"
                    + "\nEnter your choice: ");

            productChoice = scanner.nextInt();
            scanner.nextLine();
            switch (productChoice) {
                case 1:
                    logger.info("\nAvailable Products : "
                            + "\n--------------------");
                    String listToDisplay = "";
                    for (Crop crop : cropList) {
                        listToDisplay = listToDisplay
                                + "\nName :" + " " + crop.getName()
                                + "\nPrice :" + " " + "$" + crop.getPrice()
                                + "\n--------------------";
                    }
                    logger.info(listToDisplay);
                    break;
                case 2:
                    logger.info("\nAvailable Products : "
                            + "\n--------------------");
                    listToDisplay = "";
                    for (DairyProduct dairyProduct : dairyProductList) {
                        listToDisplay = listToDisplay
                                + "\nName :" + " " + dairyProduct.getName()
                                + "\nPrice :" + " " + "$" + dairyProduct.getPrice()
                                + "\nFat content :" + " " + dairyProduct.getFatContent()
                                + "\n--------------------";
                    }
                    logger.info(listToDisplay);
                    break;
                case 3:
                    logger.info("Enter the product to add: ");
                    String productName = scanner.nextLine();

                    for (Crop crop : cropList) {
//                        if (crop.getName().equalsIgnoreCase(productName)) {
                        if (crop.isEqual.test(productName)) {
                            cropCart.insertAtEnD(crop);
                            logger.info(productName + " added to the cart.");
                            break;
                        }
                    }

                    for (DairyProduct dairyProduct : dairyProductList) {
                        if (dairyProduct.isEqual.test(productName)) {
                            dairyCart.insertAtEnD(dairyProduct);
                            logger.info(productName + " added to the cart.");
                            break;
                        }
                    }

                    try {
                        if (cropCart.isEmpty() && dairyCart.isEmpty()) {
                            throw new ItemNotFoundException("Error: Product not found..");
                        }
                    } catch (ItemNotFoundException e) {
                        logger.info("Error: Product not found..");
                    }
                    break;
                case 4:
                    logger.info("Checkout process:");

                    double totalPrice = 0.0;
                    int index = 0;
                    while (index < cropCart.size()) {
                        try {
                            Crop crop = cropCart.get(index);
                            totalPrice += crop.getPrice();
                        } catch (NullValueException e) {
                            logger.info(" Invalid Index");
                        }
                        index++;
                    }
                    index = 0;
                    while (index < dairyCart.size()) {
                        try {
                            DairyProduct dairyProduct = dairyCart.get(index);
                            totalPrice += dairyProduct.getPrice();
                        } catch (NullValueException e) {
                            logger.info(" Invalid Index");
                        }
                        index++;
                    }
                    logger.info("Total Price: " + totalPrice);
                    cropCart.clear();
                    dairyCart.clear();

                    break;
                case 0:
                    break;
                default:
                    logger.info("Invalid choice. Please try again.");
            }
        }
    }

    private void loadCropProducts() {

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

    private void loadDairyProducts() {
        Butter butter = new Butter(
                "Salted Butter",
                5,
                12,
                10 / 02 / 2023);
        dairyProductList.add(butter);

        Milk milk = new Milk(
                "Cow Milk",
                true,
                8,
                10);
        dairyProductList.add(milk);

        Cheese cheese = new Cheese(
                "Cheddar Cheese",
                12,
                15,
                05 / 20 / 2023);
        dairyProductList.add(cheese);
    }
}
