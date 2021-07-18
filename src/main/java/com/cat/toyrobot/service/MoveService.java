package com.cat.toyrobot.service;

import com.cat.toyrobot.model.ToyRobot;
import org.springframework.stereotype.Service;

@Service
public class MoveService {
    public void run(ToyRobot toyRobot) {
        switch (toyRobot.getDirection()) {
            case EAST:
                toyRobot.increaseX();
                break;
            case SOUTH:
                toyRobot.decreaseY();
                break;
            case WEST:
                toyRobot.decreaseX();
                break;
            case NORTH:
                toyRobot.increaseY();
                break;
        }
    }
}
