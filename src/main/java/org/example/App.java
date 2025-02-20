package org.example;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class App {
    public static void main(String[] args) {
        GetMeasurements();
    }

    public static void CreateMeasurements() {

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/measurements/add";

        Random r = new Random();

        Map<String, Object> jsonToSend = new HashMap<>();

        Map<String, String> jsonSensor = new HashMap<>();

        jsonSensor.put("name", "Sensor for client");

        for (int i = 0; i < 5; i++) {

            jsonToSend.put("value", r.nextInt(40));
            jsonToSend.put("raining", false);
            jsonToSend.put("sensor", jsonSensor);

            HttpEntity<Map<String, Object>> request = new HttpEntity<>(jsonToSend);

            restTemplate.postForObject(url, request, String.class);

            jsonToSend.clear();

        }
    }
    public static Map<String, String> CreateSensorAndMeasurementsForHim() {

//        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/sensors/registration";

        Map<String, String> jsonToSend = new HashMap<>();

        jsonToSend.put("name", "Sensor for client");

//        HttpEntity<Map<String, Object>> request = new HttpEntity<>(jsonToSend);

//        String response = restTemplate.postForObject(url, request, String.class);


//        CreateMeasurements(jsonToSend);

        return jsonToSend;
    }
    public static void GetMeasurements() {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/measurements";

        MeasurementsResponse[] response = restTemplate.getForObject(url, MeasurementsResponse[].class);

        List<MeasurementsResponse> measurementsResponseList = Arrays.stream(response).toList();

        measurementsResponseList.forEach(System.out::println);

    }
}
