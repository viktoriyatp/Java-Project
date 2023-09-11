package com.viktoriyatp.robot;

import java.util.List;

public interface RobotService {
  List<RobotDto> getAllRobots();
  RobotDto getRobotById(int id);
  RobotDto addRobot(RobotRequestDto robotRequestDto);
  RobotDto updateRobot(int id, RobotRequestDto robotRequestDto);
  void deleteRobot(int id);
}
