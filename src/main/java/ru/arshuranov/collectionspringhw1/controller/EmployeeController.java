package ru.arshuranov.collectionspringhw1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private int req;

    @GetMapping
    public String greetings() {
        return "Hello world";
    }
    @GetMapping("/counter")
    public String greetings2() {
        return "Количество запросов" + ++req;
    }

}
