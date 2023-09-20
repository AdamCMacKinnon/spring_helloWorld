package com.example.restservice.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.example.restservice.records.Goodbye;
import com.example.restservice.records.Greeting;
import com.example.restservice.records.Multiply;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

@RestController
public class GreetingController {

    private static final String template = "Hello, This is a test %s!";
    private static final String goodbyeTemplate = "Goodbye %s!";
    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingController.class);
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        LOGGER.info("SAYING HELLO!");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    @GetMapping("/goodbye")
    public Goodbye goodbye(@RequestParam(value = "name", defaultValue = "World") String name) {
        LOGGER.info("SAYING GOODBYE!!");
        return new Goodbye(counter.decrementAndGet(), String.format(goodbyeTemplate, name));
    }
    @GetMapping("/multiply")
    public Multiply multiply(@RequestParam(value = "name", defaultValue = "Anonymous")String name) {
        LOGGER.warn("MULTIPLYING!");
        return new Multiply(counter.incrementAndGet() * 3, String.format(template, name));
    }
}
