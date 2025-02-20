package org.example;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;
import java.util.HashMap;
import java.util.Map;

public class KataApp {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://94.198.50.185:7081/api/users";

        //first request
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> forEntity = template.getForEntity(url, String.class);
        String cookie = forEntity.getHeaders().get("Set-Cookie").get(0);
        System.out.println(cookie);

        //Second request
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(HttpHeaders.COOKIE, cookie);

        Map<String, Object> jsonPost = new HashMap<>();

        jsonPost.put("id", 3);
        jsonPost.put("name", "James");
        jsonPost.put("lastName", "Brown");
        jsonPost.put("age", 34);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(jsonPost, headers);

        String response = restTemplate.postForObject(url, request, String.class);
        System.out.println(response);

        //Third response

        Map<String, Object> jsonPut = new HashMap<>();
        jsonPut.put("id", 3);
        jsonPut.put("name", "Thomas");
        jsonPut.put("lastName", "Shelby");
        jsonPut.put("age", 34);

        HttpEntity<Map<String, Object>> request2 = new HttpEntity<>(jsonPut, headers);
        ResponseEntity<String> response2 = restTemplate.exchange(url, HttpMethod.PUT, request2, String.class);
        System.out.println(response2);

        //Fourh response
        String urlDelete = "http://94.198.50.185:7081/api/users/3";
        HttpEntity<Map<String, Object>> request3 = new HttpEntity<>(headers);
        ResponseEntity<String> response3 = restTemplate.exchange(urlDelete, HttpMethod.DELETE, request2, String.class);
        System.out.println(response3);
        //5ebfeb e7cb97 5dfcf9
    }
}
