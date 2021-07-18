package com.cat.toyrobot.controller;

import com.cat.toyrobot.exception.ToyRobotFallingException;
import com.cat.toyrobot.exception.ToyRobotMissingException;
import com.cat.toyrobot.model.Direction;
import com.cat.toyrobot.model.ToyRobot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ToyRobotControllerTest {
    @Autowired
    private RestClient restClient;

    @BeforeEach
    public void setUp() {
        restClient.setUp();
    }

    @Test
    public void testShouldReturnHttpStatusOKWith01NORTHWhenPlace00NORTHAndMoveAndReport() {
        restClient.place(0,0, Direction.NORTH);
        restClient.move();
        ResponseEntity<String> responseEntity = restClient.report();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("0,1,NORTH", responseEntity.getBody());
    }

    @Test
    public void testShouldReturnHttpStatusOKWith00WESTWhenPlace00NORTHAndLeftAndReport() {
        restClient.place(0,0, Direction.NORTH);
        restClient.turnLeft();
        ResponseEntity<String> responseEntity = restClient.report();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("0,0,WEST", responseEntity.getBody());
    }

    @Test
    public void testShouldReturnHttpStatusOKWith33NORTHWhenPlace12EASTAndMoveAndMoveAndLeftAndMoveAndReport() {
        restClient.place(1,2, Direction.EAST);
        restClient.move();
        restClient.move();
        restClient.turnLeft();
        restClient.move();
        ResponseEntity<String> responseEntity = restClient.report();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("3,3,NORTH", responseEntity.getBody());
    }

    @Test
    public void testShouldReturnHttpStatusOKWithROBOTMISSINGWhenMoveAndReport() {
        restClient.move();
        ResponseEntity<String> responseEntity = restClient.report();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("ROBOT MISSING", responseEntity.getBody());
    }

    @Test
    public void testShouldReturnHttpStatusOKWith00WESTWhenPlace00NORTHAndRightAndReport() {
        restClient.place(0,0, Direction.NORTH);
        restClient.turnRight();
        ResponseEntity<String> responseEntity = restClient.report();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("0,0,EAST", responseEntity.getBody());
    }

    @Test
    public void testShouldNotPlaceSuccessfulAndShouldReturnHttpStatusBAD_REQUESTWithExceptionMessageWhenXPositionIsOutOfRange() {
        ResponseEntity<String> responseEntity = restClient.place(ToyRobot.MAX_POSITION + 1,ToyRobot.MIN_POSITION, Direction.EAST);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());

        responseEntity = restClient.place(ToyRobot.MIN_POSITION - 1,ToyRobot.MAX_POSITION, Direction.EAST);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    public void testShouldNotPlaceSuccessfulAndShouldReturnHttpStatusBAD_REQUESTWithExceptionMessageWhenYPositionIsOutOfRange() {
        ResponseEntity<String> responseEntity = restClient.place(ToyRobot.MIN_POSITION,ToyRobot.MAX_POSITION + 1, Direction.EAST);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());

        responseEntity = restClient.place(ToyRobot.MIN_POSITION,ToyRobot.MIN_POSITION - 1, Direction.EAST);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    public void testShouldNotMoveSuccessfulAndShouldReturnHttpStatusBAD_REQUESTWithToyRobotMissingExceptionMessageWhenRobotIsMissing() {
        ResponseEntity<String> responseEntity = restClient.move();

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(ToyRobotMissingException.MESSAGE, responseEntity.getBody());
    }

    @Test
    public void testShouldNotMoveSuccessfulAndShouldReturnHttpStatusBAD_REQUESTWithToyRobotFallingExceptionMessageWhenTheMoveCausesRobotToFall() {
        restClient.place(ToyRobot.MAX_POSITION,ToyRobot.MAX_POSITION, Direction.EAST);
        ResponseEntity<String> responseEntity = restClient.move();

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(ToyRobotFallingException.MESSAGE, responseEntity.getBody());
    }

    @Test
    public void testShouldNotTurnLeftSuccessfulAndShouldReturnHttpStatusBAD_REQUESTWithToyRobotMissingExceptionMessageWhenRobotIsMissing() {
        ResponseEntity<String> responseEntity = restClient.turnLeft();

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(ToyRobotMissingException.MESSAGE, responseEntity.getBody());
    }

    @Test
    public void testShouldNotTurnRightSuccessfulAndShouldReturnHttpStatusBAD_REQUESTWithToyRobotMissingExceptionMessageWhenRobotIsMissing() {
        ResponseEntity<String> responseEntity = restClient.turnRight();

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(ToyRobotMissingException.MESSAGE, responseEntity.getBody());
    }

    @Test
    public void testShouldNotDeleteSuccessfulAndShouldReturnHttpStatusBAD_REQUESTWithToyRobotMissingExceptionMessageWhenRobotIsMissing() {
        ResponseEntity<String> responseEntity = restClient.delete();

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(ToyRobotMissingException.MESSAGE, responseEntity.getBody());
    }
}