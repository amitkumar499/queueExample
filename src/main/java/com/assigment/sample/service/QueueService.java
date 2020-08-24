package com.assigment.sample.service;
/* 
Created by amit.chaurasia 
on 8/24/20 
*/

import com.assigment.sample.queue.CustomQueue;
import com.assigment.sample.response.QueueStat;
import com.assigment.sample.response.QueueStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueueService {

    @Autowired
    private CustomQueue<Integer> customQueue;

    public QueueStats getQueueStats() {
        Object[] queue = customQueue.getQueue().toArray();
        int sumFiveMinute = 0;
        int sumTenMinute = 0;
        int sumThirtyMinute = 0;
        for (int i = queue.length - 1; i >= 0; i--) {
            int element = (int) queue[i];
            if (queue.length-i <= 5 * 60 * 5) {                                   // check for elements in last 5 minutes
                sumFiveMinute += element;
            }
            if (queue.length-i <= 5 * 60 * 10) {                                  // check for elements in last 10 minutes
                sumTenMinute += element;
            }
            if (queue.length-i <= 5 * 60 * 30) {                                  // check for elements in last 30 minutes
                sumThirtyMinute += element;
            }
        }
        return prepareQueueStats(sumFiveMinute, sumTenMinute, sumThirtyMinute);
    }

    private QueueStats prepareQueueStats(int sumFiveMinute, int sumTenMinute, int sumThirtyMinute) {
        QueueStats queueStats = new QueueStats();
        List<QueueStat> stats = new ArrayList<>();
        QueueStat fiveMinuteStat = new QueueStat(5, sumFiveMinute);
        QueueStat tenMinuteStat = new QueueStat(10, sumTenMinute);
        QueueStat thirtyMinuteStat = new QueueStat(30, sumThirtyMinute);
        stats.add(fiveMinuteStat);
        stats.add(tenMinuteStat);
        stats.add(thirtyMinuteStat);
        queueStats.setQueueStats(stats);
        return queueStats;
    }
}
