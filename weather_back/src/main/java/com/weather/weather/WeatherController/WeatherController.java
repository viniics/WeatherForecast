package com.weather.weather.WeatherController;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.weather.WeatherService.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getWeather() {
        JSONObject weatherData = weatherService.getWeather();
        Map<String, Object> map = weatherData.toMap();
        return ResponseEntity.ok(map);
    }
}
