package com.maomao.spring.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduledTask {

    @Scheduled(cron = "0 0 12 ? * *")
    public void scheduledTask1() {
        System.out.println("12:00 报时");
    }

    @Scheduled(fixedRate = 5_000)
    public void scheduledTask2() {
        System.out.println("系统时间：" + System.currentTimeMillis());
    }
}
