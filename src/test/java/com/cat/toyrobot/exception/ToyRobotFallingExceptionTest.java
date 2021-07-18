package com.cat.toyrobot.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToyRobotFallingExceptionTest {

    @Test
    public void testShouldReturnToyRobotFallingExceptionMessageWhenGetMessage() {
        assertEquals(ToyRobotFallingException.MESSAGE, new ToyRobotFallingException().getMessage());
    }
}