package com.cat.toyrobot.service;

import com.cat.toyrobot.exception.ToyRobotFallingException;
import com.cat.toyrobot.model.Direction;
import com.cat.toyrobot.model.ToyRobot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoveServiceTest {
    private ToyRobot toyRobot;
    private final MoveService moveService = new MoveService();

    @Test
    public void testShouldIncreaseXWhenDirectionIsEastAndMoveDoesNotCausePositionOutOfRange(){
        toyRobot = new ToyRobot(ToyRobot.MIN_POSITION, ToyRobot.MIN_POSITION, Direction.EAST);
        moveService.run(toyRobot);

        assertEquals(ToyRobot.MIN_POSITION + 1, toyRobot.getX());
    }

    @Test
    public void testShouldDecreaseYWhenDirectionIsSouthAndMoveDoesNotCausePositionOutOfRange(){
        toyRobot = new ToyRobot(ToyRobot.MIN_POSITION, ToyRobot.MAX_POSITION, Direction.SOUTH);
        moveService.run(toyRobot);

        assertEquals(ToyRobot.MAX_POSITION - 1, toyRobot.getY());
    }

    @Test
    public void testShouldDecreaseXWhenDirectionIsWestAndMoveDoesNotCausePositionOutOfRange(){
        toyRobot = new ToyRobot(ToyRobot.MAX_POSITION, ToyRobot.MAX_POSITION, Direction.WEST);
        moveService.run(toyRobot);

        assertEquals(ToyRobot.MAX_POSITION - 1, toyRobot.getX());
    }

    @Test
    public void testShouldIncreaseYWhenDirectionIsNorthAndMoveDoesNotCausePositionOutOfRange(){
        toyRobot = new ToyRobot(ToyRobot.MIN_POSITION, ToyRobot.MIN_POSITION, Direction.NORTH);
        moveService.run(toyRobot);

        assertEquals(ToyRobot.MIN_POSITION + 1, toyRobot.getY());
    }

    @Test
    public void testShouldThrowToyRobotFallingExceptionWhenDirectionIsEastAndMoveCausesPositionOutOfRange(){
        toyRobot = new ToyRobot(ToyRobot.MAX_POSITION, ToyRobot.MIN_POSITION, Direction.EAST);
        assertThrows(ToyRobotFallingException.class, () -> moveService.run(toyRobot));
    }

    @Test
    public void testShouldThrowToyRobotFallingExceptionWhenDirectionIsSouthAndMoveCausesPositionOutOfRange(){
        toyRobot = new ToyRobot(ToyRobot.MAX_POSITION, ToyRobot.MIN_POSITION, Direction.SOUTH);
        assertThrows(ToyRobotFallingException.class, () -> moveService.run(toyRobot));
    }

    @Test
    public void testShouldThrowToyRobotFallingExceptionWhenDirectionIsWestAndMoveCausesPositionOutOfRange(){
        toyRobot = new ToyRobot(ToyRobot.MIN_POSITION, ToyRobot.MIN_POSITION, Direction.WEST);
        assertThrows(ToyRobotFallingException.class, () -> moveService.run(toyRobot));
    }

    @Test
    public void testShouldThrowToyRobotFallingExceptionWhenDirectionIsNorthAndMoveCausesPositionOutOfRange(){
        toyRobot = new ToyRobot(ToyRobot.MIN_POSITION, ToyRobot.MAX_POSITION, Direction.NORTH);
        assertThrows(ToyRobotFallingException.class, () -> moveService.run(toyRobot));
    }
}