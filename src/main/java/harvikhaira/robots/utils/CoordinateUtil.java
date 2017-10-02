package main.java.harvikhaira.robots.utils;

import main.java.harvikhaira.robots.entities.Coordinate;
import main.java.harvikhaira.robots.entities.Grid;
import main.java.harvikhaira.robots.entities.Position;

public class CoordinateUtil {
    public static boolean isRobotLost(Grid grid, Position robotPosition) {
        Coordinate minCoords = grid.getBottomLeft();
        Coordinate maxCoords = grid.getTopRight();
        Coordinate coords = robotPosition.getCoordinates();

        return coords.getXCoordinate() < minCoords.getXCoordinate()
                || coords.getXCoordinate() > maxCoords.getXCoordinate()
                || coords.getYCoordinate() < minCoords.getYCoordinate()
                || coords.getYCoordinate() > maxCoords.getYCoordinate();
    }
}
