package com.weather.weather.WeatherController;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weather.weather.Entity.CityWeather;
import com.weather.weather.ErrorMessage.CityErrorMessage;
import com.weather.weather.Exception.CityNotFoundException;
import com.weather.weather.WeatherService.WeatherService;

@RestController
@RequestMapping("/weather")
@CrossOrigin(origins = "*") // Permite requisições de qualquer origem p usar no arquivo HTML
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public ResponseEntity<CityWeather> getWeather(@RequestParam String city) {
        city = city.replaceAll(" ", "+");
        CityWeather weatherData = weatherService.getWeather(city);
        if(weatherData==null){
            throw new CityNotFoundException("City Not Found");
        }
        return ResponseEntity.ok(weatherData);
    }

    @ExceptionHandler
    public ResponseEntity<CityErrorMessage> handleException(CityNotFoundException e){
        int statusCode = HttpStatus.NOT_FOUND.value();
        LocalDateTime timestamp = LocalDateTime.now();
        CityErrorMessage cityErrorMessage = new CityErrorMessage(statusCode, e.getMessage(), timestamp);
        return new ResponseEntity<>(cityErrorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CityErrorMessage> handleException(Exception e){
        int statusCode = HttpStatus.BAD_REQUEST.value();
        LocalDateTime timestamp = LocalDateTime.now();
        CityErrorMessage cityErrorMessage = new CityErrorMessage(statusCode, e.getMessage(), timestamp);
        return new ResponseEntity<>(cityErrorMessage, HttpStatus.BAD_REQUEST);
    }
}
