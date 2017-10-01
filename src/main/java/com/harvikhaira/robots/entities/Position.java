package com.harvikhaira.robots.entities;

import com.harvikhaira.robots.enums.OrientationEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Position {
    private Coordinate coordinates;
    private OrientationEnum orientation;

    public Position(int xCoordinate, int yCoordinate, String orientation) {
        this.coordinates = new Coordinate(xCoordinate, yCoordinate);
        this.orientation = OrientationEnum.valueOf(orientation);
    }

    @Override
    public String toString() {
        return String.format("% % %", coordinates.getXCoordinate(), coordinates.getYCoordinate(), orientation.getValue());
    }
}
