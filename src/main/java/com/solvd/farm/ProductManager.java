package com.solvd.farm;

import com.solvd.farm.crop.Crop;
import com.solvd.farm.dairyproduct.DairyProduct;
import com.solvd.farm.exception.DuplicateEntryException;
import com.solvd.farm.exception.ItemNotFoundException;
import com.solvd.farm.exception.NullValueException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProductManager {
    private static final Logger logger = LogManager.getLogger(ProductManager.class);
    private ArrayList<Crop> cropList;
    private ArrayList<DairyProduct> dairyProductList;

    private LinkedList<Crop> cropCart = new LinkedList<>();
    private LinkedList<DairyProduct> dairyCart = new LinkedList<>();

    public ProductManager(ArrayList<Crop> cropData, ArrayList<DairyProduct> dairyProducts) {
        cropList = cropData;
        dairyProductList = dairyProducts;
    }
    public void setCropList(ArrayList<Crop> cropList) {
        this.cropList = cropList;
    }

    public void setDairyProductList(ArrayList<DairyProduct> dairyProductList) {
        this.dairyProductList = dairyProductList;
    }
    public void setCropCart(LinkedList<Crop> cropCart) {
        this.cropCart = cropCart;
    }

    public void setDairyCart(LinkedList<DairyProduct> dairyCart) {
        this.dairyCart = dairyCart;
    }

    public ArrayList<Crop> getCropList() {
        return cropList;
    }

    public ArrayList<DairyProduct> getDairyProductList() {
        return dairyProductList;
    }

    public LinkedList<Crop> getCropCart() {
        return cropCart;
    }

    public LinkedList<DairyProduct> getDairyCart() {
        return dairyCart;
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
                    String listToDisplay = "\nAvailable Products : "
                            + "\n--------------------\n";

                    listToDisplay = listToDisplay + cropList.stream()
                            .map(crop -> "Name : " + crop.getName()
                                    + "\nPrice : $" + crop.getPrice()
                                    + "\n--------------------")
                            .collect(Collectors.joining("\n"));

                    logger.info(listToDisplay);

                    break;
                case 2:
                    listToDisplay = "\nAvailable Products : "
                            + "\n--------------------\n";

                    listToDisplay = listToDisplay + dairyProductList.stream()
                            .map(dairyProduct -> "Name : " + dairyProduct.getName()
                                    + "\nPrice : $" + dairyProduct.getPrice()
                                    + "\nFat content : " + dairyProduct.getFatContent()
                                    + "\n--------------------")
                            .collect(Collectors.joining("\n"));

                    logger.info(listToDisplay);
                    break;
                case 3:
                    logger.info("Enter the product to add: ");
                    String productName = scanner.nextLine();
                    try {
                        if (cropCart.search(productName) || dairyCart.search(productName)) {
                            throw new DuplicateEntryException("Duplicate item found");
                        }
                        boolean isProductFound = cropList.stream()
                                .filter(crop -> crop.isEqual.test(productName))
                                .findFirst()
                                .map(crop -> {
                                    cropCart.insertatend(crop);
                                    logger.info(productName + " added to the cart.");
                                    return true;
                                })
                                .orElseGet(() -> dairyProductList.stream()
                                        .filter(dairyProduct -> dairyProduct.isEqual.test(productName))
                                        .findFirst()
                                        .map(dairyProduct -> {
                                            dairyCart.insertatend(dairyProduct);
                                            logger.info(productName + " added to the cart.");
                                            return true;
                                        })
                                        .orElse(false));

                        if (!isProductFound) {
                            throw new ItemNotFoundException("Error: Product not found..");
                        }
                    } catch (ItemNotFoundException | DuplicateEntryException e) {
                        logger.info("Error: " + e.getMessage());
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
}