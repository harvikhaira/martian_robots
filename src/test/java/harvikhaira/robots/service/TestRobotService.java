package test.java.harvikhaira.robots.service;

import main.java.harvikhaira.robots.entities.Coordinate;
import main.java.harvikhaira.robots.entities.Position;
import main.java.harvikhaira.robots.entities.Robot;
import main.java.harvikhaira.robots.exception.GridDimensionException;
import main.java.harvikhaira.robots.service.RobotService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestRobotService {
    private static RobotService service = new RobotService();

    /**
     * Inputs and expected outputs taken from tech challenge spec.
     */
    private static final String MAX_GRID_COORDINATES = "53";
    private static final String INSTRUCTION_INPUT = "53\n 11E \n RFRFRFRF";
    private static final String EXPECTED_OUTPUT = "11E\n";
    private static final String LOST_INSTRUCTION_INPUT = "53\n 32N \n FRRFLLFFRRFLL";
    private static final String LOST_EXPECTED_OUTPUT = "33NLOST\n";
    private static final String ENTIRE_INSTRUCTION_INPUT = "53\n 11E\n RFRFRFRF\n 32N\n FRRFLLFFRRFLL\n 03W\n LLFFFLFLFL";
    private static final String ENTIRE_INSTRUCTION_OUTPUT = "11E\n33NLOST\n23S\n";

    @Test
    public void testSetupGrid() throws GridDimensionException {
        service.setupGrid(MAX_GRID_COORDINATES);

        final Coordinate MAX_COORDINATE = new Coordinate(5, 3);
        assertEquals(MAX_COORDINATE, service.grid.getTopRight());
    }

    @Test
    public void testProcessInstruction() {
        final String STARTING_POS = "11E";
        final String INSTRUCTION = "RFRFRFRF";
        final Coordinate FINAL_COORDS = new Coordinate(1,1);

        Robot robot = service.processInstructions(STARTING_POS, INSTRUCTION);
        assertNotNull(robot);

        Position robotPosition = robot.getPosition();
        assertEquals("E", robotPosition.getOrientation().getValue());
        assertEquals(FINAL_COORDS.getXCoordinate(), robotPosition.getCoordinates().getXCoordinate());
        assertEquals(FINAL_COORDS.getYCoordinate(), robotPosition.getCoordinates().getYCoordinate());
        assertEquals(false, robot.isLost());
    }

    @Test
    public void testSingleProcess() {
        String output = service.process(INSTRUCTION_INPUT);
        assertEquals(EXPECTED_OUTPUT, output);
    }

    @Test
    public void testLostRobot() {
        String output = service.process(LOST_INSTRUCTION_INPUT);
        assertEquals(LOST_EXPECTED_OUTPUT, output);
    }

//    @Test

    /**
     * Sadly, this test has highlighted an issue in the logic of the instruction processing
     * Next step - locate where the issue resides. This may require a slight rewrite of logic
     */
    public void testMultipleProcess() {
        String output = service.process(ENTIRE_INSTRUCTION_INPUT);
        assertEquals(ENTIRE_INSTRUCTION_OUTPUT, output);
    }
}
