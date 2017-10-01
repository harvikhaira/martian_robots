package com.harvikhaira.robots.enums;

public enum OrientationEnum {
    NORTH("N", 0, 1),
    SOUTH("S", 0, -1),
    EAST("E", -1, 0),
    WEST("W", 1, 0);

    private final String value;
    //setup which direction on respective axis to go
    private final int xCoordinate;
    private final int yCoordinate;

    OrientationEnum(String value, int xCoordinate, int yCoordinate) {
        this.value = value;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
}
