package com.cat.toyrobot.model;

import com.cat.toyrobot.exception.ToyRobotFallingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ToyRobotTest {
    private ToyRobot toyRobot;

    @BeforeEach
    public void setUp() {
        toyRobot = new ToyRobot();
    }

    @Test
    public void testShouldIncreaseXWhenIncreaseXDoesNotCausePositionOutOfRange() {
        toyRobot.setX(ToyRobot.MIN_POSITION);
        toyRobot.increaseX();
        assertEquals(ToyRobot.MIN_POSITION + 1, toyRobot.getX());
    }

    @Test
    public void testShouldIncreaseYWhenIncreaseYDoesNotCausePositionOutOfRange() {
        toyRobot.setY(ToyRobot.MIN_POSITION);
        toyRobot.increaseY();
        assertEquals(ToyRobot.MIN_POSITION + 1, toyRobot.getY());
    }

    @Test
    public void testShouldDecreaseXWhenDecreaseXDoesNotCausePositionOutOfRange() {
        toyRobot.setX(ToyRobot.MAX_POSITION);
        toyRobot.decreaseX();
        assertEquals(ToyRobot.MAX_POSITION - 1, toyRobot.getX());
    }

    @Test
    public void testShouldDecreaseYWhenDecreaseYDoesNotCausePositionOutOfRange() {
        toyRobot.setY(ToyRobot.MAX_POSITION);
        toyRobot.decreaseY();
        assertEquals(ToyRobot.MAX_POSITION - 1, toyRobot.getY());
    }

    @Test
    public void testShouldThrowToyRobotFallingExceptionWhenIncreaseXCausesPositionOutOfRange() {
        toyRobot.setX(ToyRobot.MAX_POSITION);
        assertThrows(ToyRobotFallingException.class, () -> toyRobot.increaseX());
    }

    @Test
    public void testShouldThrowToyRobotFallingExceptionWhenIncreaseYCausesPositionOutOfRange() {
        toyRobot.setY(ToyRobot.MAX_POSITION);
        assertThrows(ToyRobotFallingException.class, () -> toyRobot.increaseY());
    }

    @Test
    public void testShouldThrowToyRobotFallingExceptionWhenDecreaseXCausesPositionOutOfRange() {
        toyRobot.setX(ToyRobot.MIN_POSITION);
        assertThrows(ToyRobotFallingException.class, () -> toyRobot.decreaseX());
    }

    @Test
    public void testShouldThrowToyRobotFallingExceptionWhenDecreaseYCausesPositionOutOfRange() {
        toyRobot.setY(ToyRobot.MIN_POSITION);
        assertThrows(ToyRobotFallingException.class, () -> toyRobot.decreaseY());
    }
}