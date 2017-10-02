package main.java.harvikhaira.robots.service;

import main.java.harvikhaira.robots.entities.Grid;
import main.java.harvikhaira.robots.entities.Position;
import main.java.harvikhaira.robots.entities.Robot;
import main.java.harvikhaira.robots.exception.GridDimensionException;
import main.java.harvikhaira.robots.utils.CoordinateUtil;
import main.java.harvikhaira.robots.utils.InstructionUtil;

import java.util.Arrays;

public class RobotService {
    public Grid grid;

    public String process(String instruction) {
        final StringBuilder output = new StringBuilder();
        if(instruction != null && instruction.length() > 0) {
            //split the input by a new line;
            String[] instructions = instruction.trim().split("\\n");
            instructions = Arrays.stream(instructions).filter(x -> !x.isEmpty()).toArray(String[]::new);
            try {
                //first instruction is the grid boundary
                setupGrid(instructions[0].trim());

                for (int i = 1; i < instructions.length; i += 2) {
                    //check for any blank lines - instruction separators
                    if(instructions[i].length() > 0) {
                        final Robot robot = processInstructions(instructions[i].trim(), instructions[i + 1].trim());
                        output.append(robot.toString() + "\n");
                    }
                }
            } catch (GridDimensionException e) {
                return e.getMessage();
            }
        }

        return output.toString();
    }

    public void setupGrid(String coords) throws GridDimensionException {
        final String[] vals = coords.split("");
        grid = new Grid(vals[0], vals[1]);
    }

    public Robot processInstructions(String startingPos, String instruction) {
        final String[] startingCoords = startingPos.split("");
        final Robot robot = new Robot(startingCoords);

        final String[] instructions = instruction.split("");
        for (int i = 0; i < instructions.length; i++) {
            if(!robot.isLost()) {
                //create new position
                //check instruction - turn L/R or move forward
                final Position newPosition = InstructionUtil.processInstruction(robot.getPosition(), instructions[i]);

                //check whether new position is within grid boundary
                //mark robot as lost if invalid co-ordinates
                boolean lost = CoordinateUtil.isRobotLost(grid, newPosition);
                robot.setLost(lost);

                if(!lost) {
                    //set robot's position to be new position
                    //updating the orientation or the coordinates
                    robot.setPosition(newPosition);
                }
            }
        }

        return robot;
    }
}
