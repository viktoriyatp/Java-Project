package com.viktoriyatp.order;

import java.time.LocalDateTime;

public class Order {
  private int id;
  private int clientId;
  private String origin;
  private String destination;
  private int productId;
  private LocalDateTime dateOfOrder;
  private int robotId;
  private String status;
  private int orderDetailsId;

  public Order() {
  }

  public Order(
    int id, int clientId, String origin, String destination, int productId, LocalDateTime dateOfOrder, int robotId,
    String status, int orderDetailsId) {
    this.id = id;
    this.clientId = clientId;
    this.origin = origin;
    this.destination = destination;
    this.productId = productId;
    this.dateOfOrder = dateOfOrder;
    this.robotId = robotId;
    this.status = status;
    this.orderDetailsId = orderDetailsId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getClientId() {
    return clientId;
  }

  public void setClientId(int clientId) {
    this.clientId = clientId;
  }

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public LocalDateTime getDateOfOrder() {
    return dateOfOrder;
  }

  public void setDateOfOrder(LocalDateTime dateOfOrder) {
    this.dateOfOrder = dateOfOrder;
  }

  public int getRobotId() {
    return robotId;
  }

  public void setRobotId(int robotId) {
    this.robotId = robotId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public int getOrderDetailsId() {
    return orderDetailsId;
  }

  public void setOrderDetailsId(int orderDetailsId) {
    this.orderDetailsId = orderDetailsId;
  }
}
