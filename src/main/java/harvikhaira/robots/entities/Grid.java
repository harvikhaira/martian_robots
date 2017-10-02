package main.java.harvikhaira.robots.entities;

import main.java.harvikhaira.robots.exception.GridDimensionException;
import lombok.Data;

@Data
public class Grid {
    private final int MAX_BOUNDARY_COORD = 50;
    private final Coordinate bottomLeft = new Coordinate(0,0);
    private Coordinate topRight;

    public Grid(final String xCoord, final String yCoord) throws NumberFormatException, GridDimensionException {
        int x = Integer.parseInt(xCoord);
        int y = Integer.parseInt(yCoord);
        if(x <= MAX_BOUNDARY_COORD && y <= MAX_BOUNDARY_COORD) {
            this.topRight = new Coordinate(x, y);
        } else {
            throw new GridDimensionException();
        }
    }
}
