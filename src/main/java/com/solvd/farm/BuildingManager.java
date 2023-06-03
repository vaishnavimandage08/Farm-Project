package com.solvd.farm;

import com.solvd.farm.building.Building;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Scanner;

public class BuildingManager {
    private static final Logger logger = LogManager.getLogger(BuildingManager.class);
    private final ArrayList<Building> buildingList;
    public BuildingManager(ArrayList<Building> buildingList) {
        this.buildingList = buildingList;
    }
    public void displayBuildingPortal() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            logger.info("\n" +
                    "╔════════════════════════════════╗\n" +
                    "║          Building Portal       ║\n" +
                    "╠════════════════════════════════╣\n" +
                    "║ 1. View list of all buildings  ║\n" +
                    "║ 2. Set Temperature             ║\n" +
                    "║ 0. Back to Main Menu           ║\n" +
                    "╚════════════════════════════════╝\n" +
                    "Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    String line = "list of all buildings"
                            + "\nBuilding Name      Head of Department"
                            + "\n----------------------------------------";
                    for (Building building : buildingList) {
                        line = line
                                + "\n" + building.getBuildingName()
                                + "          "
                                + building.getHeadOfDepartment();
                    }
                    logger.info(line);
                }
                break;

                case 2:
                    logger.info("Enter Name of a building: ");
                    String name = scanner.nextLine();
                    boolean isFound = buildingList.stream()
                            .anyMatch(building -> building.getBuildingName().equalsIgnoreCase(name));
                    if (!isFound) {
                        logger.info("Building not found");
                    } else {
                        logger.info("Set temperature (Integer):");
                        int temp = scanner.nextInt();

                        buildingList.forEach(building -> {
                            if (building.getBuildingName().equalsIgnoreCase(name)) {
                                building.setTemperature(temp);
                            }
                        });
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
