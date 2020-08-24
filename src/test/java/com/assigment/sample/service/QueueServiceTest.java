package com.assigment.sample.service;
/* 
Created by amit.chaurasia 
on 8/25/20 
*/

import com.assigment.sample.queue.ThirtyMinuteQueue;
import com.assigment.sample.response.QueueStats;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class QueueServiceTest {

    @InjectMocks
    private QueueService queueService;

    @Before
    public void mockData() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private ThirtyMinuteQueue<Integer> thirtyMinuteQueue;

    @Test
    public void getQueueStats_statsBeforeFiveMinutes(){
        ThirtyMinuteQueue<Integer> responseQueue=new ThirtyMinuteQueue<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 500; i++)
            list.add(i);
        responseQueue.addAll(list);
        Mockito.when(thirtyMinuteQueue.getQueue()).thenReturn(responseQueue.getQueue());
        QueueStats queueStats=queueService.getQueueStats();
        Assert.assertEquals(queueStats.getQueueStats().get(0).getSum(),500*(501)/2);
        Assert.assertEquals(queueStats.getQueueStats().get(1).getSum(),500*(501)/2);
        Assert.assertEquals(queueStats.getQueueStats().get(2).getSum(),500*(501)/2);
    }

    @Test
    public void getQueueStats_statsBetweenFiveAndTenMinutes(){
        ThirtyMinuteQueue<Integer> responseQueue=new ThirtyMinuteQueue<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 2000; i++)
            list.add(i);
        responseQueue.addAll(list);
        Mockito.when(thirtyMinuteQueue.getQueue()).thenReturn(responseQueue.getQueue());
        QueueStats queueStats=queueService.getQueueStats();
        Assert.assertEquals(queueStats.getQueueStats().get(0).getSum(),1500*501 + 1500*1499/2);  // AP formula => n*a+n*(n-1)/2
        Assert.assertEquals(queueStats.getQueueStats().get(1).getSum(),2000*(2001)/2);
        Assert.assertEquals(queueStats.getQueueStats().get(2).getSum(),2000*(2001)/2);
    }

    @Test
    public void getQueueStats_statsBetweenTenAndThirtyMinutes(){
        ThirtyMinuteQueue<Integer> responseQueue=new ThirtyMinuteQueue<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 4000; i++)
            list.add(i);
        responseQueue.addAll(list);
        Mockito.when(thirtyMinuteQueue.getQueue()).thenReturn(responseQueue.getQueue());
        QueueStats queueStats=queueService.getQueueStats();
        Assert.assertEquals(queueStats.getQueueStats().get(0).getSum(),1500*2501 + 1500*1499/2);   // AP formula => n*a+n*(n-1)/2
        Assert.assertEquals(queueStats.getQueueStats().get(1).getSum(),3000*1001 + 3000*2999/2);   // AP formula => n*a+n*(n-1)/2
        Assert.assertEquals(queueStats.getQueueStats().get(2).getSum(),4000*(4001)/2);
    }

    @Test
    public void getQueueStats_statsBetweenAfterThirtyMinutes(){
        ThirtyMinuteQueue<Integer> responseQueue=new ThirtyMinuteQueue<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9000; i++)
            list.add(i);
        responseQueue.addAll(list);
        list = new ArrayList<>();
        list.add(1);
        responseQueue.addAll(list);
        Mockito.when(thirtyMinuteQueue.getQueue()).thenReturn(responseQueue.getQueue());
        QueueStats queueStats=queueService.getQueueStats();
        Assert.assertEquals(queueStats.getQueueStats().get(0).getSum(),1500*7502 + 1500*1499/2 +1);   // AP formula => n*a+n*(n-1)/2
        Assert.assertEquals(queueStats.getQueueStats().get(1).getSum(),3000*6002 + 3000*2999/2 +1);    // AP formula => n*a+n*(n-1)/2
        Assert.assertEquals(queueStats.getQueueStats().get(2).getSum(),9000*(9001)/2);
    }

}
