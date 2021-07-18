package com.cat.toyrobot.service;

import com.cat.toyrobot.model.Direction;
import com.cat.toyrobot.model.ToyRobot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurnLeftServiceTest {
    private final ToyRobot toyRobot = new ToyRobot(0, 0, Direction.EAST);

    private final TurnLeftService turnLeftService = new TurnLeftService();

    @Test
    public void testShouldTurnToWestWhenDirectionIsNorth() {
        toyRobot.setDirection(Direction.NORTH);
        turnLeftService.run(toyRobot);
        assertEquals(Direction.WEST, toyRobot.getDirection());
    }

    @Test
    public void testShouldTurnToSouthWhenDirectionIsWest() {
        toyRobot.setDirection(Direction.WEST);
        turnLeftService.run(toyRobot);
        assertEquals(Direction.SOUTH, toyRobot.getDirection());
    }

    @Test
    public void testShouldTurnToEastWhenDirectionIsSouth() {
        toyRobot.setDirection(Direction.SOUTH);
        turnLeftService.run(toyRobot);
        assertEquals(Direction.EAST, toyRobot.getDirection());
    }

    @Test
    public void testShouldTurnToNorthWhenDirectionIsEast() {
        toyRobot.setDirection(Direction.EAST);
        turnLeftService.run(toyRobot);
        assertEquals(Direction.NORTH, toyRobot.getDirection());
    }
}