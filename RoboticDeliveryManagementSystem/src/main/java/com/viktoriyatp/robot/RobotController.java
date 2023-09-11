package com.viktoriyatp.robot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
public class RobotController {
  public final RobotServiceImpl robotService;

  public RobotController(RobotServiceImpl robotService) {
    this.robotService = robotService;
  }

  @GetMapping("/robots")
  ResponseEntity<List<RobotDto>> getAllRobots() {
    return ResponseEntity.ok(robotService.getAllRobots());
  }

  @GetMapping("/robots/{id}")
  ResponseEntity<RobotDto> getRobotById(@PathVariable int id) {
    return ResponseEntity.ok(robotService.getRobotById(id));
  }

  @PostMapping("/robots")
  ResponseEntity<RobotDto> addRobot(@RequestBody RobotRequestDto robotRequestDto) {
    RobotDto robot = robotService.addRobot(robotRequestDto);

    URI location = UriComponentsBuilder.fromUriString("/robots/{id}").buildAndExpand(robot.getId()).toUri();

    return ResponseEntity.created(location).build();
  }

  @PutMapping("/robots/{id}")
  ResponseEntity<RobotDto> updateRobot(@PathVariable int id, @RequestBody RobotRequestDto robotRequestDto) {
    RobotDto robot = robotService.updateRobot(id, robotRequestDto);

    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/robots/{id}")
  ResponseEntity<Void> deleteRobot(@PathVariable int id) {
    robotService.deleteRobot(id);

    return ResponseEntity.noContent().build();
  }
}
