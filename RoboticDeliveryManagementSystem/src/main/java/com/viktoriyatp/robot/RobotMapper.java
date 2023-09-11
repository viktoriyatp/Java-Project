package com.viktoriyatp.robot;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RobotMapper {
  RobotDto toRobotDto(Robot robot);
  Robot toRobot(RobotRequestDto robotRequestDto);
  void updateRobot(@MappingTarget Robot robot, RobotRequestDto robotRequestDto);
}
