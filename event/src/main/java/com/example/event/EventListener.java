package com.example.event;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EventListener implements ApplicationListener<Event> {
    @Override
    @Async
    public void onApplicationEvent(Event event) {
        System.out.println("listener: Thread.currentThread() = " + Thread.currentThread());
        System.out.println("event = " + event);
    }
}
