package com.cdk.carbuy.controller;

import com.cdk.carbuy.dto.Car;
import com.cdk.carbuy.dto.Customer;
import com.cdk.carbuy.dto.Lead;
import com.cdk.carbuy.dto.Order;
import com.cdk.carbuy.exceptions.CarBuyException;
import com.cdk.carbuy.service.CarService;
import com.cdk.carbuy.service.OrderService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by ashoka on 9/1/2016.
 */
@Controller
public class CarController {
    @Autowired
    private OrderService orderService = null;

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    private CarService carService = null;

    public CarService getCarService() {
        return carService;
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public
    @ResponseBody
    ArrayList<Car> getCarListings(HttpServletRequest request, HttpServletResponse response) throws CarBuyException{
        ArrayList<Car> carList = null;
            carList = carService.getCars();
            return carList;
    }

    @RequestMapping(value = "/placeOrder", method = RequestMethod.POST)
    public
    @ResponseBody
        String placeOrder(HttpServletRequest request, HttpServletResponse response, Lead lead) {
        Car car = new Car(lead.getId(), lead.getMake(), lead.getModel(), lead.getYear(), lead.getPrice());
        Customer customer = new Customer(lead.getCustomerId(), lead.getName(), lead.getAddress(), lead.getEmail(), lead.getContact_no());
        Order order = new Order(customer,car);
        order = orderService.addOrder(order);
        Gson gson = new Gson();
        return gson.toJson(order);

    }

}

