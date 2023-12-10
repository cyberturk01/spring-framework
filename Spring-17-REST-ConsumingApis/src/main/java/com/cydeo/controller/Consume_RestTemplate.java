package com.cydeo.controller;

import com.cydeo.dto.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@RestController
@RequestMapping("/users")
public class Consume_RestTemplate {

    private final String URI = "https://jsonplaceholder.typicode.com/users";

    private final RestTemplate restTemplate;

    public Consume_RestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public User[] readAllUsers(){
//getForEntity used for mapping to DTO
        ResponseEntity<User[]>  responseEntity = restTemplate.getForEntity(URI,User[].class);

        return responseEntity.getBody();

    }

    @GetMapping("{id}")
    public Object readUser(@PathVariable("id") Integer id){
//getForObject getting the 3rd party data passing to my end point
        String URL = URI + "/{id}";

        return restTemplate.getForObject(URL,Object.class,id);
    }


    @GetMapping("/test")
    public ResponseEntity<Object> consumeFromDummyApi(){
//create headers and add more filelds if needed
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("app-id","6298ebfecd0551211fce37a6");
//exchange method needs HTTP-Entity class
        HttpEntity<String> entity = new HttpEntity<>(headers);

        //exchange method we are passing headers
        ResponseEntity<Object> response = restTemplate.exchange("https://dummyapi.io/data/v1/user?limit=10", HttpMethod.GET,entity,Object.class);

        return response;

    }
}











