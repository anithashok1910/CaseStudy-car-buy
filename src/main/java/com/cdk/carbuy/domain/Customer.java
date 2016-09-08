package com.cdk.carbuy.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by guptah on 8/24/2016.
 */
@Entity
@Table(name = "customer_t")
@Component
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "mob_no")
    private long mob_no;

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                "email id =" + email + '\'' +
                "mobile number =" + mob_no + '\''+
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMob_no() {
        return mob_no;
    }

    public void setMob_no(long mob_no) {
        this.mob_no = mob_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer() {
    }

    public Customer(com.cdk.carbuy.dto.Customer customer){
        this.name = customer.getName();
        this.address = customer.getAddress();
        this.email = customer.getEmail();
        this.mob_no = customer.getMob_no();

    }
}

