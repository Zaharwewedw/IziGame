package com.example.bot.controler;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {

    @GetMapping("/get")
    public ResponseEntity<Map<String, Integer>> get() {
        Map<String, Integer> map = new HashMap<>();

        map.put("One", 1);
        map.put("Two", 2);

        return  new ResponseEntity<>(map, HttpStatusCode.valueOf(200));
    }
}
