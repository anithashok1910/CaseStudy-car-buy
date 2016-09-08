package com.cdk.carbuy.services;

import com.cdk.carbuy.dao.OrderDAO;
import com.cdk.carbuy.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ashoka on 9/8/2016.
 */
@Component
public class OrderService {

    @Autowired
    public OrderDAO orderDAO;

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public Order addOrder(Order order){
        order = orderDAO.addOrder(order);
        return order;
    }
}
