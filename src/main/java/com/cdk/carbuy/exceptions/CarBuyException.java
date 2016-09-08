package com.cdk.carbuy.exceptions;

/**
 * Created by ashoka on 9/8/2016.
 */
public class CarBuyException extends Exception{
    private String message;

    public CarBuyException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CarBuyException{" +
                "message='" + message + '\'' +
                '}';
    }
}
