package com.cat.toyrobot.exception;

public class ToyRobotFallingException extends RuntimeException {
    public static final String MESSAGE = "The request was not executed to prevent the Robot from falling to destruction.";

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
