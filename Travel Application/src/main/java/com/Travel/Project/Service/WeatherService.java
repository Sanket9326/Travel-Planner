package com.Travel.Project.Service;

import okhttp3.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherService {
    private static final String API_URL = "http://api.weatherapi.com/v1/current.json";
    private static final String API_KEY = "7ae3761f02e147768ad171656242207";

    private final OkHttpClient client = new OkHttpClient();

    public ResponseEntity<String> getWeather(String city) {

        String url = String.format("%s?key=%s&q=%s", API_URL, API_KEY, city);


        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                return new ResponseEntity<>(responseBody, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (IOException e) {
            return new ResponseEntity<>("Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
