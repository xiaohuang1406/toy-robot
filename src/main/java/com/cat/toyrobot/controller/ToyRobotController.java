package com.cat.toyrobot.controller;

import com.cat.toyrobot.exception.ToyRobotMissingException;
import com.cat.toyrobot.model.ToyRobot;
import com.cat.toyrobot.service.MoveService;
import com.cat.toyrobot.service.ReportService;
import com.cat.toyrobot.service.TurnLeftService;
import com.cat.toyrobot.service.TurnRightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("robot")
public class ToyRobotController {
    private ToyRobot toyRobot;

    @Autowired
    private MoveService moveService;

    @Autowired
    private TurnLeftService turnLeftService;

    @Autowired
    private TurnRightService turnRightService;

    @Autowired
    private ReportService reportService;

    @PostMapping("/place")
    @ResponseStatus(HttpStatus.CREATED)
    void place(@Valid @RequestBody ToyRobot toyRobot) {
        this.toyRobot = toyRobot;
    }

    @PutMapping("/move")
    void move() {
         this.validateToyRobotMissing();
         this.moveService.run(this.toyRobot);
    }

    @PutMapping("/left")
    void turnLeft() {
        this.validateToyRobotMissing();
        this.turnLeftService.run(this.toyRobot);
    }

    @PutMapping("/right")
    void turnRight() {
        this.validateToyRobotMissing();
        this.turnRightService.run(this.toyRobot);
    }

    @GetMapping("/report")
    String report() {
        return this.reportService.run(this.toyRobot);
    }

    @DeleteMapping("/delete")
    void delete() {
        this.validateToyRobotMissing();
        this.toyRobot = null;
    }

    private void validateToyRobotMissing() {
        if (this.toyRobot == null) {
            throw new ToyRobotMissingException();
        }
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleToyRobotFallingException(Exception exception) {
        return exception.getMessage();
    }
}
