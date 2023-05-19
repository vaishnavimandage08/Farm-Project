package com.solvd.farm.enums;


public enum FarmHours {
    MONDAY("09:00", "18:00"),
    TUESDAY("09:00", "18:00"),
    WEDNESDAY("09:00", "18:00"),
    THURSDAY("09:00", "18:00"),
    FRIDAY("09:00", "18:00"),
    SATURDAY("09:00", "15:00"),
    SUNDAY("Closed", "Closed");

    private final String openingTime;
    private final String closingTime;

    public String getOpeningTime() {
        return openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    FarmHours(String openingTime, String closingTime) {
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

}


