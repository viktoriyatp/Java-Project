package com.viktoriyatp.exceptions;

public class ClientNotFound extends RuntimeException{

  public ClientNotFound(String message) {
    super(message);
  }
}
