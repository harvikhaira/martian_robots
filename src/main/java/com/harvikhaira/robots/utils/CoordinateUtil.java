package com.harvikhaira.robots.utils;

import com.harvikhaira.robots.entities.Coordinate;
import com.harvikhaira.robots.entities.Grid;
import com.harvikhaira.robots.entities.Position;

public class CoordinateUtil {
    public static boolean isRobotLost(Grid grid, Position robotPosition) {
        Coordinate minCoords = grid.getBottomLeft();
        Coordinate maxCoords = grid.getTopRight();
        Coordinate coords = robotPosition.getCoordinates();

        if (coords.getXCoordinate() < minCoords.getXCoordinate()
                && coords.getXCoordinate() > maxCoords.getXCoordinate()) {
            return false;
        }

        if(coords.getYCoordinate() < minCoords.getYCoordinate()
                && coords.getYCoordinate() > maxCoords.getYCoordinate()) {
            return false;
        }

        return true;
    }
}
