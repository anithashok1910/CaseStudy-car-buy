package com.cdk.carbuy.controller;

import com.cdk.carbuy.dto.Car;
import com.cdk.carbuy.dto.Customer;
import com.cdk.carbuy.dto.Order;
import com.cdk.carbuy.services.CarService;
import com.cdk.carbuy.services.OrderService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by ashoka on 9/1/2016.
 */
@Controller
public class CarController {
    @Autowired
    private OrderService orderService =null;

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


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public @ResponseBody
    ArrayList<Car> getCarListings(HttpServletRequest request, HttpServletResponse response){
        ArrayList<Car> carList = null;
        try {
            carList = carService.getCars();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return carList;
        }
    }
    @RequestMapping(value = "/placeOrder",method = RequestMethod.POST)
    public @ResponseBody
    String placeOrder(HttpServletRequest request, HttpServletResponse response)
    {

        Car car = new Car();
        car.setId(Integer.parseInt(request.getParameter("carId")));
        car.setModel(request.getParameter("model"));
        car.setMake(request.getParameter("make"));
        car.setPrice(Integer.parseInt(request.getParameter("price")));
        car.setYear(Integer.parseInt(request.getParameter("year")));
        Customer customer = new Customer();
        customer.setName(request.getParameter("name"));
        customer.setAddress(request.getParameter("address"));
        customer.setEmail(request.getParameter("email"));
        customer.setMob_no(Long.parseLong(request.getParameter("mob_no")));
        Order order = new Order();
        order.setCustomer(customer);
        order.setCar(car);
        order=orderService.addOrder(order);
        Gson gson = new Gson();
        return gson.toJson(order);
    }

}

