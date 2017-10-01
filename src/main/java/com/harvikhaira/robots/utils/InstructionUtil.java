package com.harvikhaira.robots.utils;

import com.harvikhaira.robots.entities.Coordinate;
import com.harvikhaira.robots.entities.Position;
import com.harvikhaira.robots.entities.Robot;
import com.harvikhaira.robots.enums.InstructionEnum;
import com.harvikhaira.robots.enums.OrientationEnum;

public class InstructionUtil {
    public static Position processInstruction(Robot robot, String instruction) {
        Position newPosition = new Position();
        Position current = robot.getPosition();

        OrientationEnum newOrientation;

        switch (InstructionEnum.valueOf(instruction)) {
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
                //generate new coordinates based off orientation
                Coordinate newCoords = OrientationUtil.getNewCoordinates(current.getOrientation(), current.getCoordinates());
                newPosition.setCoordinates(newCoords);
                break;
        }

        return newPosition;
    }
}
