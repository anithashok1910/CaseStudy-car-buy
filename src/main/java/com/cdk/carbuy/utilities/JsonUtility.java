package com.cdk.carbuy.utilities;

import com.cdk.carbuy.exceptions.CarBuyException;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by ashoka on 9/8/2016.
 */
public class JsonUtility {

    public static JsonReader readJsonfile(String filename) throws CarBuyException {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filename);
        } catch (FileNotFoundException e) {
            throw new CarBuyException(e.toString());
        }
        JsonReader reader = new JsonReader(fileReader);
        return reader;
    }
}
