package com.harvikhaira.robots.entities;

import com.harvikhaira.robots.enums.OrientationEnum;
import lombok.Data;

@Data
public class Position {
    private Coordinate coordinates;
    private OrientationEnum orientation;

    public Position(int xCoordinate, int yCoordinate, String orientation) {
        this.coordinates = new Coordinate(xCoordinate, yCoordinate);
        this.orientation = OrientationEnum.valueOf(orientation);
    }

    public Position() {

    }
}
