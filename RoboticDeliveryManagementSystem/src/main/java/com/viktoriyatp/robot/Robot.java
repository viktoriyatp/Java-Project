package java.com.viktoriyatp.robot;

public class Robot {
  private int id;
  private String model;
  private double capacityOfTrailer;
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
