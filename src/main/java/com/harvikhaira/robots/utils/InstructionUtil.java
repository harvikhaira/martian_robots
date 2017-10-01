package com.harvikhaira.robots.utils;

import com.harvikhaira.robots.entities.Position;
import com.harvikhaira.robots.entities.Robot;
import com.harvikhaira.robots.enums.InstructionEnum;

public class InstructionUtil {
    public static void processInstruction(Robot robot, InstructionEnum instruction) {
        Position newPosition = new Position();

        switch (instruction) {
            case RIGHT:
                //check the current orientation of the robot
                //turn right 90 degrees
                //* mark which co-ordinate to update
                break;
            case LEFT:
                //check current orientation of the robot
                //turn left 90 degrees
                //* mark co-ordinate to update
                break;
            case FORWARD:
                //update whichever co-ordinate depending on
                //orientation
//                newPosition = updatePosition()
                break;
        }
    }
}
