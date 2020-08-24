package com.assigment.sample.controller;
/* 
Created by amit.chaurasia 
on 8/23/20 
*/

import com.assigment.sample.response.QueueStats;
import com.assigment.sample.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueueController {

    @Autowired
    private QueueService queueService;

    /**This api aims at providing queue data pushed
     * in last 5 minutes, 10 minutes and 30 minutes.
     */
    @GetMapping("queue/stats")
    public QueueStats getQueueStats() {
        return queueService.getQueueStats();
    }

}
