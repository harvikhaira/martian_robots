package com.harvikhaira.robots.service;

import com.harvikhaira.robots.service.exception.GridDimensionException;

public class Grid {
    private final int MAX_BOUNDARY_COORD = 50;
    private final Position bottomLeft = new Position(0,0);
    private Position topRight;

    public Grid(final int xCoord, final int yCoord) throws GridDimensionException {
        if(xCoord <= MAX_BOUNDARY_COORD && yCoord <= MAX_BOUNDARY_COORD) {
            this.topRight = new Position(xCoord, yCoord);
        } else {
            throw new GridDimensionException();
        }
    }
}
