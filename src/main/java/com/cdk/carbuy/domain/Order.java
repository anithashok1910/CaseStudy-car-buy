package com.cdk.carbuy.domain;


import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by guptah on 9/1/2016.
 */
@Entity
@Table(name = "order_t")
@Component
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private int orderID;

    @OneToOne(cascade = javax.persistence.CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id",unique = false)
    private Customer customer;

    @OneToOne(cascade = javax.persistence.CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="car_id",unique = false)
    private Car car;

    public Order() {
    }

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

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order(com.cdk.carbuy.dto.Order order){
        this.customer = new Customer(order.getCustomer());
        this.car = new Car(order.getCar());
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
