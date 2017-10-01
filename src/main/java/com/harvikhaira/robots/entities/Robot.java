package com.harvikhaira.robots.entities;

import lombok.Data;

@Data
public class Robot {
    private Position position;
    private boolean lost = false;

    public Robot(String xCoord, String yCoord, String orientation) {
        int x = Integer.parseInt(xCoord);
        int y = Integer.parseInt(yCoord);
        this.position = new Position(x, y, orientation);
    }

    public Robot(String[] setup) {
        this(setup[0], setup[1], setup[2]);
    }

    @Override
    public String toString() {
        return position.toString() + (this.lost ? " LOST" : "");
    }
}
