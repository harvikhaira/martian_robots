package com.harvikhaira.robots.service;

import com.harvikhaira.robots.entities.Grid;
import com.harvikhaira.robots.entities.Robot;
import com.harvikhaira.robots.exception.GridDimensionException;

import java.util.Arrays;

public class RobotService {

    private static Grid grid;

    public String process(String instruction) {
        if(instruction != null && instruction.length() > 0) {
            //split the input by a new line;
            String[] instructions = instruction.split("\\n");

            try {
                //first instruction is the grid boundary
                setupGrid(instructions[0]);

                for (int i = 1; i < instructions.length; i += 3 /*2*/) {
                    //check for any blank lines - instruction separators
                    if(instructions[i].length() > 0) {
                        processInstructions(instructions[i], instructions[i + 1]);
                    }
                }
            } catch (GridDimensionException e) {
                return e.getMessage();
            }
        }

        //TEMP output
        return "processed!";
    }

    private void setupGrid(String coords) throws GridDimensionException {
        String[] vals = coords.split("");
        grid = new Grid(vals[0], vals[1]);
    }

    private void processInstructions(String startingPos, String instruction) {
        String[] robotInit = startingPos.split("");
        Robot robot = new Robot(robotInit);

        String[] instrucions = instruction.split("");
        Arrays.stream(instrucions)
                .forEach(i -> {
                    //create new position
                    //Position newPosition = new Position();

                    //check instruction - turn L/R or move forward

                    //set robot's position to be new position
                    //robot.setPosition(newPosition);

                    //check whether new position is within grid boundary
                        //mark robot as lost if invalid co-ordinates
                });
    }
}
