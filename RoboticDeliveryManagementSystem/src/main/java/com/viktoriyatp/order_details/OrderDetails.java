package java.com.viktoriyatp.order_details;

import java.math.BigDecimal;

public class OrderDetails {
  private int id;
  private double duration;
  private double distance;
  private BigDecimal price;

  public OrderDetails() {
  }

  public OrderDetails(int id, double duration, double distance, BigDecimal price) {
    this.id = id;
    this.duration = duration;
    this.distance = distance;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getDuration() {
    return duration;
  }

  public void setDuration(double duration) {
    this.duration = duration;
  }

  public double getDistance() {
    return distance;
  }

  public void setDistance(double distance) {
    this.distance = distance;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }
}
