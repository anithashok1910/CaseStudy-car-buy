package com.cdk.carbuy.dto;


/**
 * Created by guptah on 9/1/2016.
 */


public class Order {

    private int orderID;

    private Customer customer;

    private Car car;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Order(com.cdk.carbuy.domain.Order order){
        this.setOrderID(order.getOrderID());
        this.car=new Car(order.getCar());
        this.customer = new Customer(order.getCustomer());
    }

    public Order() {
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

        @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", car=" + car +
                ", customer=" + customer +
                '}';
    }


}
