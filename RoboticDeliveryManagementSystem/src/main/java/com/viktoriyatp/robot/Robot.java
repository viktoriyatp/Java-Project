package com.viktoriyatp.robot;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "robots")
public class Robot {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(name = "model")
  private String model;
  @Column(name = "capacity_of_trailer")
  private double capacityOfTrailer;
  @Column(name = "max_speed")
  private double maxSpeed;

  public Robot() {
  }

  public Robot(int id, String model, double capacityOfTrailer, double maxSpeed) {
    this.id = id;
    this.model = model;
    this.capacityOfTrailer = capacityOfTrailer;
    this.maxSpeed = maxSpeed;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
