package com.cdk.carbuy.dto;


/**
 * Created by guptah on 9/1/2016.
 */


public class Order {

    private int orderId;

    private Customer customer;

    private Car car;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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
        this.setOrderId(order.getOrderID());
        this.car=new Car(order.getCar());
        this.customer = new Customer(order.getCustomer());
    }

    public Order() {
    }

    public Order(Customer customer, Car car) {
        this.customer = customer;
        this.car = car;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

        @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderId +
                ", car=" + car +
                ", customer=" + customer +
                '}';
    }


}
