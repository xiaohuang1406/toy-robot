package com.cat.toyrobot.model;

public enum Direction {
    // This order reflects the real order of direction.
    SOUTH, EAST, NORTH, WEST;

    public static Direction getDirectionByOrdinal(int ordinal) {
        if (ordinal < 0 || ordinal >= values().length) {
            return null;
        }
        return values()[ordinal];
    }
}
