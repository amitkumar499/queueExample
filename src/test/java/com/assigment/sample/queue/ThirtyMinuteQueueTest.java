package com.assigment.sample.queue;
/* 
Created by amit.chaurasia 
on 8/24/20 
*/

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class ThirtyMinuteQueueTest {

    @InjectMocks
    private ThirtyMinuteQueue<Integer> thirtyMinuteQueue;

    @Before
    public void mockData() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addAll_addListOfIntegers() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        thirtyMinuteQueue.addAll(list);
        Assert.assertEquals(thirtyMinuteQueue.getQueue().size(), 2);
    }

    @Test
    public void addAll_addListOfIntegersAfterCapacityBreach() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 9000; i++)
            list.add(i);
        thirtyMinuteQueue.addAll(list);
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        thirtyMinuteQueue.addAll(list);
        Assert.assertEquals(thirtyMinuteQueue.getQueue().size(), 9000);
    }

    @Test
    public void getQueue_checkAfterInsertingOneElement() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        //list.add(2);
        thirtyMinuteQueue.addAll(list);
        int poll=thirtyMinuteQueue.getQueue().poll();
        Assert.assertEquals(poll, 1);
    }

    @Test
    public void getQueue_checkAfterInsertingElementOnceCapacityIsBreached() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9000; i++)
            list.add(i);
        thirtyMinuteQueue.addAll(list);
        list = new ArrayList<>();
        list.add(1);
        thirtyMinuteQueue.addAll(list);
        int poll=thirtyMinuteQueue.getQueue().poll();
        Assert.assertEquals(poll, 2);
    }


}
