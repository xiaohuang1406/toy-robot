package com.cat.toyrobot.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectionTest {
    @Test
    public void testShouldReturnCorrectDirectionWhenPassTheCorrespondingOrdinal() {
        for (Direction value : Direction.values()) {
            assertEquals(value, Direction.getDirectionByOrdinal(value.ordinal()));
        }
    }

    @Test
    public void testShouldReturnNullWhenTheOrdinalIsOutOfRange() {
        assertNull(Direction.getDirectionByOrdinal(-1));
        assertNull(Direction.getDirectionByOrdinal(Direction.values().length));
    }

}