package com.solvd.farm;

import com.solvd.farm.building.Barn;
import com.solvd.farm.building.Building;
import com.solvd.farm.building.Storage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Scanner;

public class BuildingManager {
    private ArrayList<Building> buildingList = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger(BuildingManager.class);

    public BuildingManager() {
        loadData();
    }

    public void displayBuildingPortal() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            logger.info("\n" +
                    "╔════════════════════════════════╗\n" +
                    "║          Building Portal       ║\n" +
                    "╠════════════════════════════════╣\n" +
                    "║ 1.View a list of all buildings ║\n" +
                    "║ 0. Back to Main Menu           ║\n" +
                    "╚════════════════════════════════╝\n" +
                    "Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    logger.info("list of all buildings");
                    for (Building building : buildingList) {
                        logger.info(building.getBuildingName());
                        logger.info("--------------------");
                    }
                }
                break;
                case 0:
                    break;
                default:
                    logger.info("Invalid choice. Please try again.");
            }
        }
    }
    public void setTemperatureOfStorage(int i) {
        Storage.currentTemp = i;
    }

    private void loadData() {
        Storage storage = new Storage(
                "Grain bin",
                "Jonathan",
                100,
                "cold");
        buildingList.add(storage);

        Barn barn = new Barn(
                "Dairy barn",
                "Andrew",
                50,
                true);
        storage.setLocked(true);
        barn.setLocked(false);
        buildingList.add(barn);
    }
}
