package com.example.livraria.exception;

import org.springframework.http.HttpStatus;

public class ErrorBody {
  public HttpStatus status;
  public String message;

  public ErrorBody(HttpStatus status, String message){
    this.status = status;
    this.message = message;
  }
}
