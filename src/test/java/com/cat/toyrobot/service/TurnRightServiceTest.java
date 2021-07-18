package com.cat.toyrobot.service;

import com.cat.toyrobot.model.Direction;
import com.cat.toyrobot.model.ToyRobot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurnRightServiceTest {
    private final ToyRobot toyRobot = new ToyRobot(0, 0, Direction.EAST);

    private final TurnRightService turnRightService = new TurnRightService();

    @Test
    public void testShouldTurnToEastWhenDirectionIsNorth() {
        toyRobot.setDirection(Direction.NORTH);
        turnRightService.run(toyRobot);
        assertEquals(Direction.EAST, toyRobot.getDirection());
    }

    @Test
    public void testShouldTurnToNorthWhenDirectionIsWest() {
        toyRobot.setDirection(Direction.WEST);
        turnRightService.run(toyRobot);
        assertEquals(Direction.NORTH, toyRobot.getDirection());
    }

    @Test
    public void testShouldTurnToWestWhenDirectionIsSouth() {
        toyRobot.setDirection(Direction.SOUTH);
        turnRightService.run(toyRobot);
        assertEquals(Direction.WEST, toyRobot.getDirection());
    }

    @Test
    public void testShouldTurnToSouthWhenDirectionIsEast() {
        toyRobot.setDirection(Direction.EAST);
        turnRightService.run(toyRobot);
        assertEquals(Direction.SOUTH, toyRobot.getDirection());
    }
}