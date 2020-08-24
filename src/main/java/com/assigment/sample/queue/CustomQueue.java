package com.assigment.sample.queue;
/* 
Created by amit.chaurasia 
on 8/23/20 
*/

import java.util.List;
import java.util.concurrent.BlockingQueue;

public interface CustomQueue<T> {

    void addAll(List<T> obj);

    BlockingQueue<T> getQueue();
}
