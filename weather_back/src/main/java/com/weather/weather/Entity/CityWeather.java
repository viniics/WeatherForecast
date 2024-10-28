package com.weather.weather.Entity;

public class CityWeather {
    private String city;
    private String country;
    private Double temp;
    
    public CityWeather(String city, String country, Double temp) {
        this.city = city;
        this.country = country;
        this.temp = temp;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }
    
    
}
