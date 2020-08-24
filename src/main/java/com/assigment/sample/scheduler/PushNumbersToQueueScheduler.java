package com.assigment.sample.scheduler;
/* 
Created by amit.chaurasia 
on 8/23/20 
*/

import com.assigment.sample.queue.ThirtyMinuteQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class PushNumbersToQueueScheduler {

    @Autowired
    private ThirtyMinuteQueue<Integer> queue;

    @Scheduled(cron = "* * * * * ?")
    void pushNumbersToQueue() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            randomNumbers.add(ThreadLocalRandom.current().nextInt(100));
        }
        queue.addAll(randomNumbers);
    }
}
