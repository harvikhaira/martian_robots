package com.harvikhaira.robots.utils;

import com.harvikhaira.robots.entities.Coordinate;
import com.harvikhaira.robots.enums.OrientationEnum;

public class OrientationUtil {
    public static Coordinate getNewCoordinates(OrientationEnum newOrientation, Coordinate currentCoordinates) {
        Coordinate newCoordinates = null;
        switch (newOrientation) {
            case NORTH:
                newCoordinates = new Coordinate(currentCoordinates.getXCoordinate(), currentCoordinates.getYCoordinate() + 1);
                break;
            case SOUTH:
                newCoordinates = new Coordinate(currentCoordinates.getXCoordinate(), currentCoordinates.getYCoordinate() - 1);
                break;
            case EAST:
                newCoordinates = new Coordinate(currentCoordinates.getXCoordinate() + 1, currentCoordinates.getYCoordinate());
                break;
            case WEST:
                newCoordinates = new Coordinate(currentCoordinates.getXCoordinate() - 1, currentCoordinates.getYCoordinate());
                break;
        }

        return newCoordinates;
    }
}
