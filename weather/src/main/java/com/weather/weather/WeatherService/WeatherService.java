package com.weather.weather.WeatherService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import org.json.JSONObject;

import netscape.javascript.JSObject;

public class WeatherService {

    private static final String WEB_SERVICE = "http://api.weatherapi.com/v1";
    private static final String API = "/forecast.json";
    private static final String API_KEY = "?key=3d6accf6c96c4a10bc4174734242610";
    private static final String CITY = "&q=Campina+Grande";
    private URL url;

    public WeatherService(){

        try {
            String finalUrl = WEB_SERVICE+API+API_KEY+CITY;
            this.url = new URI(finalUrl).toURL();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader dataResponse = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            JSONObject response = new JSONObject(dataResponse.readLine());
        }catch(Exception e)
    {
        System.out.println(e.getMessage());
    }

}
}
