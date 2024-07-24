package com.Travel.Project.Controller;

import com.Travel.Project.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weather")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("get")
    public ResponseEntity<String> getWeather(@RequestParam String city){
         return weatherService.getWeather(city);
    }
}
