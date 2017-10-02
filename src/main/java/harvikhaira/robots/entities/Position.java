package main.java.harvikhaira.robots.entities;

import main.java.harvikhaira.robots.enums.OrientationEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Position {
    private Coordinate coordinates;
    private OrientationEnum orientation;

    public Position(int xCoordinate, int yCoordinate, String orientation) {
        this.coordinates = new Coordinate(xCoordinate, yCoordinate);
        this.orientation = OrientationEnum.getEnum(orientation);
    }

    @Override
    public String toString() {
        return String.valueOf(coordinates.getXCoordinate()) + String.valueOf(coordinates.getYCoordinate()) + orientation.getValue();
    }
}
