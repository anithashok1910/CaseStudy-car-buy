package com.cdk.carbuy.dto;

/**
 * Created by guptah on 8/24/2016.
 */

public class Customer {
    public Customer() {
    }

    private int customerId;

    private String name;

    private String address;

    private String email;

    private long mobileNumber;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer(int customerId, String name, String address, String email, long mobileNumber) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Customer(com.cdk.carbuy.domain.Customer customer){
        this.customerId = customer.getCustomerId();
        this.name = customer.getName();
        this.address = customer.getAddress();
        this.email = customer.getEmail();
        this.mobileNumber = customer.getMobileNumber();
    }
}

