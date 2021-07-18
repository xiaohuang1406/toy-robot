package com.cat.toyrobot.service;

import com.cat.toyrobot.model.Direction;
import com.cat.toyrobot.model.ToyRobot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportServiceTest {
    private final ReportService reportService = new ReportService();

    @Test
    public void testShouldReturnROBOTMISSINGWhenToyRobotIsNull() {
        ToyRobot toyRobot = null;
        assertEquals("ROBOT MISSING", reportService.run(toyRobot));
    }

    @Test
    public void testShouldReturnPositionWhenToyRobotIsNotNull() {
        ToyRobot toyRobot = new ToyRobot(ToyRobot.MIN_POSITION, ToyRobot.MAX_POSITION, Direction.EAST);
        String expectedReturnValue = toyRobot.getX() + "," + toyRobot.getY() + "," + toyRobot.getDirection().name();
        assertEquals(expectedReturnValue, reportService.run(toyRobot));
    }
}