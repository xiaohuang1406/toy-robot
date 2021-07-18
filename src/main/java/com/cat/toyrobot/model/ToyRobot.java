package com.cat.toyrobot.model;

import com.cat.toyrobot.exception.ToyRobotFallingException;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class ToyRobot {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 4;

    @Min(MIN_POSITION)
    @Max(MAX_POSITION)
    private int x;

    @Min(MIN_POSITION)
    @Max(MAX_POSITION)
    private int y;

    private Direction direction;

    public ToyRobot() {
    }

    public ToyRobot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    private void validatePosition(int position) {
        if (position < MIN_POSITION || position > MAX_POSITION) {
            throw new ToyRobotFallingException();
        }
    }

    public void increaseX() {
        validatePosition(this.x + 1);
        this.x++;
    }

    public void decreaseX() {
        validatePosition(this.x - 1);
        this.x--;
    }

    public void increaseY() {
        validatePosition(this.y + 1);
        this.y++;
    }

    public void decreaseY() {
        validatePosition(this.y - 1);
        this.y--;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
