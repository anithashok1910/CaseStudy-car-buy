package com.cdk.carbuy.dto;

/**
 * Created by ashoka on 9/8/2016.
 */
public class Lead {
    private int customerId;
    private String name;
    private String address;
    private String email;
    private long contact_no;
    private int id;
    private String make;
    private String model;
    private int price;
    private int year;

    public Lead(int customerId, String name, String address, String email, long contact_no, int id, String make, String model, int price, int year) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.contact_no = contact_no;
        this.id = id;
        this.make = make;
        this.model = model;
        this.price = price;
        this.year = year;
    }

    public Lead() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getContact_no() {
        return contact_no;
    }

    public void setContact_no(long contact_no) {
        this.contact_no = contact_no;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Lead{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", contact_no=" + contact_no +
                ", id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", year=" + year +
                '}';
    }
}
