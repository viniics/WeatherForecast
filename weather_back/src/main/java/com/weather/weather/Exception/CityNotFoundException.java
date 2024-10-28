package com.weather.weather.Exception;

public class CityNotFoundException extends RuntimeException {
    public CityNotFoundException(String message){
        super(message);
    }
}
