package com.viktoriyatp.exceptions;

public class RobotNotFound extends RuntimeException{

  public RobotNotFound(String message) {
    super(message);
  }
}
