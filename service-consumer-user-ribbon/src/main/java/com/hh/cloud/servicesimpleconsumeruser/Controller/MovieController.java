package com.hh.cloud.servicesimpleconsumeruser.Controller;

import com.hh.cloud.servicesimpleconsumeruser.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id){
        ResponseEntity<User> userResponseEntity = restTemplate.getForEntity("http://service-provider-user/simple/" + id, User.class);
        return userResponseEntity.getBody();
    }

}
