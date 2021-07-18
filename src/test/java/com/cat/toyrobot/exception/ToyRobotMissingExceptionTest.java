package com.cat.toyrobot.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToyRobotMissingExceptionTest {

    @Test
    public void testShouldReturnToyRobotMissingExceptionMessageWhenGetMessage() {
        assertEquals(ToyRobotMissingException.MESSAGE, new ToyRobotMissingException().getMessage());
    }
}