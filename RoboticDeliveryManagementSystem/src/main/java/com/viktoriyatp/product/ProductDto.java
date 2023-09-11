package com.viktoriyatp.product;

import java.math.BigDecimal;

public class ProductDto {
  private int id;
  private String type;
  private int currentQuantity;
  private BigDecimal price;

  public ProductDto() {
  }

  public ProductDto(int id, String type, int currentQuantity, BigDecimal price) {
    this.id = id;
    this.type = type;
    this.currentQuantity = currentQuantity;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getCurrentQuantity() {
    return currentQuantity;
  }

  public void setCurrentQuantity(int currentQuantity) {
    this.currentQuantity = currentQuantity;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }
}
