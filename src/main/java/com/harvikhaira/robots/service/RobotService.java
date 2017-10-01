package com.harvikhaira.robots.service;

import com.harvikhaira.robots.entities.Grid;
import com.harvikhaira.robots.entities.Position;
import com.harvikhaira.robots.entities.Robot;
import com.harvikhaira.robots.exception.GridDimensionException;
import com.harvikhaira.robots.utils.CoordinateUtil;
import com.harvikhaira.robots.utils.InstructionUtil;

import java.util.Arrays;

public class RobotService {

    private static Grid grid;

    public String process(String instruction) {
        final StringBuilder output = new StringBuilder();
        if(instruction != null && instruction.length() > 0) {
            //split the input by a new line;
            final String[] instructions = instruction.split("\\n");

            try {
                //first instruction is the grid boundary
                setupGrid(instructions[0]);

                for (int i = 1; i < instructions.length; i += 3 /*2*/) {
                    //check for any blank lines - instruction separators
                    if(instructions[i].length() > 0) {
                        final Robot robot = processInstructions(instructions[i], instructions[i + 1]);
                        output.append(robot.toString() + "\n");
                    }
                }
            } catch (GridDimensionException e) {
                return e.getMessage();
            }
        }

        return output.toString();
    }

    private void setupGrid(String coords) throws GridDimensionException {
        final String[] vals = coords.split("");
        grid = new Grid(vals[0], vals[1]);
    }

    private Robot processInstructions(String startingPos, String instruction) {
        final String[] startingCoords = startingPos.split("");
        final Robot robot = new Robot(startingCoords);

        final String[] instructions = instruction.split("");
        Arrays.stream(instructions)
                .forEach(i -> {
                    //create new position
                    //check instruction - turn L/R or move forward
                    final Position newPosition = InstructionUtil.processInstruction(robot, i);

                    //set robot's position to be new position
                    //updating the orientation or the coordinates
                    robot.setPosition(newPosition);

                    //check whether new position is within grid boundary
                        //mark robot as lost if invalid co-ordinates
                    robot.setLost(CoordinateUtil.isRobotLost(grid, newPosition));
                });

        return robot;
    }
}
