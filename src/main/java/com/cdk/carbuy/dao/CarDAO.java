package com.cdk.carbuy.dao;


import com.cdk.carbuy.domain.Car;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by ashoka on 9/1/2016.
 */
@Component
public class CarDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public Car addCar(Car car) {
        hibernateTemplate.save(car);
        return car;
    }

    public Car get(int carID) {
        return (Car) hibernateTemplate.get(Car.class,carID);
    }
}
