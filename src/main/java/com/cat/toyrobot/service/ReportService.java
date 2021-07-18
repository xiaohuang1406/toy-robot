package com.cat.toyrobot.service;

import com.cat.toyrobot.model.ToyRobot;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    public String run(ToyRobot toyRobot) {
        return toyRobot == null ? "ROBOT MISSING"
                : toyRobot.getX() + "," + toyRobot.getY() + "," + toyRobot.getDirection();
    }
}
