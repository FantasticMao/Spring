package com.maomao.spring.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyTask {

    @Async
    public void task1(Integer i) {
        System.out.println("task1 " + i);
    }

    @Async
    public void task2(Integer i) {
        System.out.println("task2 " + i);
    }
}
