package com.solvd.farm.enums;


public enum FarmHours {
    MONDAY("09:00", "18:00"),
    TUESDAY("09:00", "18:00"),
    WEDNESDAY("09:00", "18:00"),
    THURSDAY("09:00", "18:00"),
    FRIDAY("09:00", "18:00"),
    SATURDAY("09:00", "15:00"),
    SUNDAY("Closed", "Closed");

    private final String open;
    private final String close;

    public String getOpeningTime() {
        return open;
    }

    public String getClosingTime() {
        return close;
    }

     FarmHours(String open, String close) {
        this.open = open;
        this.close = close;
    }

}


