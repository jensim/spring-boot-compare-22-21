package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class MyController {

    @GetMapping
    public void getter(
            @RequestParam String foo1,
            @RequestParam String foo2,
            @RequestParam String foo3,
            @RequestParam String foo4,
            @RequestParam String foo5,
            @RequestParam String foo6,
            @RequestParam String foo7,
            @RequestParam String foo8,
            @RequestParam String foo9) {
        // Do nothing
    }

    @PostMapping
    public void poster(MyRequestBody body) {
        // Do nothing
    }
}
