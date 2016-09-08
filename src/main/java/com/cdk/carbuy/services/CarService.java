package com.cdk.carbuy.services;

import com.cdk.carbuy.dao.CarDAO;
import com.cdk.carbuy.dto.Car;
import com.cdk.carbuy.exceptions.CarBuyException;
import com.cdk.carbuy.utilities.JsonUtility;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by ashoka on 9/8/2016.
 */
@Component
public class CarService {

    @Autowired
    private CarDAO carDAO = null;

    public CarDAO getCarDAO() {
        return carDAO;
    }

    public void setCarDAO(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public ArrayList<Car> getCars() throws CarBuyException {
        Gson gson = new Gson();
        com.cdk.carbuy.dto.Car cars[] = gson.fromJson(JsonUtility.readJsonfile("C:\\Users\\ashoka\\Desktop\\Final Project\\mock-data\\cars.json"), com.cdk.carbuy.dto.Car[].class);
        ArrayList<com.cdk.carbuy.dto.Car> carList = new ArrayList();
        if(cars.length!=0){
            for(int i = 0; i<cars.length;i++){
            com.cdk.carbuy.dto.Car car = new com.cdk.carbuy.dto.Car(cars[i].getId(),cars[i].getMake(),cars[i].getModel(),cars[i].getYear(),cars[i].getPrice(),cars[i].getDescription(),cars[i].getImageURL());
            carList.add(car);
        }
    }
        return carList;
    }
}
