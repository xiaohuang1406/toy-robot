package com.cat.toyrobot.controller;

import com.cat.toyrobot.model.Direction;
import com.cat.toyrobot.model.ToyRobot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RestClient {
    private static final String ROBOT_ENDPOINT = "/robot";
    private static final String PLACE_ROBOT_ENDPOINT = ROBOT_ENDPOINT + "/place";
    private static final String MOVE_ROBOT_ENDPOINT = ROBOT_ENDPOINT + "/move";
    private static final String LEFT_ROBOT_ENDPOINT = ROBOT_ENDPOINT + "/left";
    private static final String RIGHT_ROBOT_ENDPOINT = ROBOT_ENDPOINT + "/right";
    private static final String REPORT_ROBOT_ENDPOINT = ROBOT_ENDPOINT + "/report";
    private static final String DELETE_ROBOT_ENDPOINT = ROBOT_ENDPOINT + "/delete";

    @Autowired
    private TestRestTemplate testRestTemplate;

    ResponseEntity<String> place(int x, int y, Direction direction) {
        return testRestTemplate.postForEntity(PLACE_ROBOT_ENDPOINT, new ToyRobot(x, y, direction), String.class);
    }

    ResponseEntity<String> move() {
        return testRestTemplate.exchange(MOVE_ROBOT_ENDPOINT, HttpMethod.PUT, null, String.class);
    }

    ResponseEntity<String> turnLeft() {
        return testRestTemplate.exchange(LEFT_ROBOT_ENDPOINT, HttpMethod.PUT, null, String.class);
    }

    ResponseEntity<String> turnRight() {
        return testRestTemplate.exchange(RIGHT_ROBOT_ENDPOINT, HttpMethod.PUT, null, String.class);
    }

    ResponseEntity<String> report() {
        return testRestTemplate.getForEntity(REPORT_ROBOT_ENDPOINT, String.class);
    }

    ResponseEntity<String> delete() {
        return testRestTemplate.exchange(DELETE_ROBOT_ENDPOINT, HttpMethod.DELETE, null, String.class);
    }

    ResponseEntity<String> setUp() {
        return delete();
    }
}
