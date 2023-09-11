package com.viktoriyatp.robot;

public class RobotRequestDto {
  private String model;
  private double capacityOfTrailer;
  private double maxSpeed;

  public RobotRequestDto() {
  }

  public RobotRequestDto(String model, double capacityOfTrailer, double maxSpeed) {
    this.model = model;
    this.capacityOfTrailer = capacityOfTrailer;
    this.maxSpeed = maxSpeed;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public double getCapacityOfTrailer() {
    return capacityOfTrailer;
  }

  public void setCapacityOfTrailer(double capacityOfTrailer) {
    this.capacityOfTrailer = capacityOfTrailer;
  }

  public double getMaxSpeed() {
    return maxSpeed;
  }

  public void setMaxSpeed(double maxSpeed) {
    this.maxSpeed = maxSpeed;
  }
}
