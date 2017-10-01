package com.harvikhaira.robots.utils;

import com.harvikhaira.robots.entities.Coordinate;
import com.harvikhaira.robots.entities.Position;
import com.harvikhaira.robots.enums.InstructionEnum;
import com.harvikhaira.robots.enums.OrientationEnum;

public class InstructionUtil {
    public static Position processInstruction(Position current, String instruction) {
        Position newPosition = new Position();

        OrientationEnum newOrientation;

        switch (InstructionEnum.getEnum(instruction)) {
            case RIGHT:
                //turn right 90 degrees
                newOrientation = current.getOrientation().getRightValue();

                //set the new orientation
                newPosition.setOrientation(newOrientation);
                //use current coordinates due to no movement
                newPosition.setCoordinates(current.getCoordinates());
                break;
            case LEFT:
                //turn left 90 degrees
                newOrientation = current.getOrientation().getLeftValue();

                //set the new orientation
                newPosition.setOrientation(newOrientation);
                //use current coordinates due to no movement
                newPosition.setCoordinates(current.getCoordinates());
                break;
            case FORWARD:
                newPosition.setOrientation(current.getOrientation());
                //generate new coordinates based off orientation
                Coordinate newCoords = OrientationUtil.getNewCoordinates(current.getOrientation(), current.getCoordinates());
                newPosition.setCoordinates(newCoords);
                break;
        }

        return newPosition;
    }
}
