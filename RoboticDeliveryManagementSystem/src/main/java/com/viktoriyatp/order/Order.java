package com.viktoriyatp.order;

import com.viktoriyatp.client.Client;
import com.viktoriyatp.order_details.OrderDetails;
import com.viktoriyatp.product.Product;
import com.viktoriyatp.robot.Robot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @JoinColumn(name = "client_id")
  @OneToOne(fetch = FetchType.LAZY)
  private Client client;
  @Column(name = "origin")
  private String origin;
  @Column(name = "destination")
  private String destination;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id")
  private Product product;
  @Column(name = "date_of_order")
  private LocalDateTime dateOfOrder;
  @JoinColumn(name = "robot_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Robot robot;
  @Column(name = "status")
  private String status;
  @JoinColumn(name = "order_details_id")
  @OneToOne(fetch = FetchType.LAZY)
  private OrderDetails orderDetails;

  public Order() {
  }

  public Order(
    int id, Client client, String origin, String destination, Product product, LocalDateTime dateOfOrder, Robot robot,
    String status, OrderDetails orderDetails) {
    this.id = id;
    this.client = client;
    this.origin = origin;
    this.destination = destination;
    this.product = product;
    this.dateOfOrder = dateOfOrder;
    this.robot = robot;
    this.status = status;
    this.orderDetails = orderDetails;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public LocalDateTime getDateOfOrder() {
    return dateOfOrder;
  }

  public void setDateOfOrder(LocalDateTime dateOfOrder) {
    this.dateOfOrder = dateOfOrder;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public Robot getRobot() {
    return robot;
  }

  public void setRobot(Robot robot) {
    this.robot = robot;
  }

  public OrderDetails getOrderDetails() {
    return orderDetails;
  }

  public void setOrderDetails(OrderDetails orderDetails) {
    this.orderDetails = orderDetails;
  }
}
