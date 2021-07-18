package com.cat.toyrobot.service;

import com.cat.toyrobot.model.Direction;
import com.cat.toyrobot.model.ToyRobot;

public abstract class AbstractTurnService {
    public void run(ToyRobot toyRobot) {
        int currentDirectionOrdinal = toyRobot.getDirection().ordinal();
        int nextDirectionOrdinal = getNextDirectionOrdinal(currentDirectionOrdinal);
        Direction nextDirection = Direction.getDirectionByOrdinal(nextDirectionOrdinal);

        if (nextDirection != null) {
            toyRobot.setDirection(nextDirection);
        }
    }

    protected abstract int getNextDirectionOrdinal(int currentDirectionOrdinal);
}
