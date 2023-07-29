package com.example.event;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class EventController {

    @Resource
    private EventPublisher eventPublisher;

    @GetMapping("hello")
    public String hello() {
        eventPublisher.publish(new Event("hello"));
        return "hello";
    }
}
