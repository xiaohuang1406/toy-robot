package com.cat.toyrobot.exception;

public class ToyRobotMissingException extends RuntimeException {
    public static final String MESSAGE = "The request was not executed as the Robot is missing.";

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
