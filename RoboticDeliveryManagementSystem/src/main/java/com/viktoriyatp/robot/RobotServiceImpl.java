package com.viktoriyatp.robot;

import com.viktoriyatp.exceptions.ProductNotFound;
import com.viktoriyatp.exceptions.RobotNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import static com.viktoriyatp.constants.RobotConstants.ROBOT_NOT_FOUND;

@Service
public class RobotServiceImpl implements RobotService{

  public final RobotRepository robotRepository;
  public final RobotMapper robotMapper;

  @Autowired
  public RobotServiceImpl(RobotRepository robotRepository, RobotMapper robotMapper) {
    this.robotRepository = robotRepository;
    this.robotMapper = robotMapper;
  }

  @Override
  public List<RobotDto> getAllRobots() {
    return robotRepository.findAll().stream().map(robotMapper::toRobotDto).collect(Collectors.toList());
  }

  @Override
  public RobotDto getRobotById(int id) {
    Robot robot = robotRepository.findById(id).orElseThrow(() -> new RobotNotFound(String.format(ROBOT_NOT_FOUND,id)));
    return robotMapper.toRobotDto(robot);
  }

  @Override
  public RobotDto addRobot(RobotRequestDto robotRequestDto) {
    Robot robot = robotMapper.toRobot(robotRequestDto);
    robotRepository.save(robot);

    return robotMapper.toRobotDto(robot);
  }

  @Override
  public RobotDto updateRobot(int id, RobotRequestDto robotRequestDto) {
    Robot robot = robotRepository.findById(id).orElseThrow(() -> new RobotNotFound(String.format(ROBOT_NOT_FOUND,id)));
    robotMapper.updateRobot(robot,robotRequestDto);
    robotRepository.save(robot);

    return robotMapper.toRobotDto(robot);
  }

  @Override
  public void deleteRobot(int id) {
    boolean doesExist = robotRepository.existsById(id);

    if(!doesExist) {
      throw new ProductNotFound(String.format(ROBOT_NOT_FOUND,id));
    }

    robotRepository.deleteById(id);
  }
}
