package com.viktoriyatp.product;

import java.math.BigDecimal;

public class ProductRequestDto {
  private String type;
  private int currentQuantity;
  private BigDecimal price;

  public ProductRequestDto() {
  }

  public ProductRequestDto(String type, int currentQuantity, BigDecimal price) {
    this.type = type;
    this.currentQuantity = currentQuantity;
    this.price = price;
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
