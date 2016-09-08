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
    String FILENAME = "C:\\Users\\ashoka\\Desktop\\Final Project\\mock-data\\cars.json";

    public ArrayList<com.cdk.carbuy.dto.Car> getCarData() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(FILENAME));
        com.cdk.carbuy.dto.Car cars[] = gson.fromJson(reader, com.cdk.carbuy.dto.Car[].class);
        ArrayList<com.cdk.carbuy.dto.Car> carList = new ArrayList();
        for(int i = 0; i<cars.length;i++){
            com.cdk.carbuy.dto.Car car = new com.cdk.carbuy.dto.Car();
            car.setId(cars[i].getId());
            car.setMake(cars[i].getMake());
            car.setModel(cars[i].getModel());
            car.setYear(cars[i].getYear());
            car.setPrice(cars[i].getPrice());
            car.setDescription(cars[i].getDescription());
            car.setImageURL(cars[i].getImageURL());
            carList.add(car);
        }
        return carList;
    }


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
