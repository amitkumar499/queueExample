package com.assigment.sample.queue;
/* 
Created by amit.chaurasia 
on 8/23/20 
*/

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Component
public class ThirtyMinuteQueue<T> implements CustomQueue<T> {

    private BlockingQueue<T> queue;

    private static final int CAPACITY = 30 * 60 * 5;

    @Override
    public synchronized void addAll(List obj) {
        if (queue == null)
            queue = new ArrayBlockingQueue<>(CAPACITY);
        if (queue.size() == CAPACITY) {
            for (int i = 0; i < obj.size(); i++) {
                queue.poll();
            }
        }
        queue.addAll(obj);
    }

    @Override
    public BlockingQueue<T> getQueue() {
        return queue;
    }

}
