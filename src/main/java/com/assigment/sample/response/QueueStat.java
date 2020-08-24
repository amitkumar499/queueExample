package com.assigment.sample.response;
/* 
Created by amit.chaurasia 
on 8/24/20 
*/

public class QueueStat {

    private int duration;
    private int sum;

    public QueueStat(int duration, int sum) {
        this.duration = duration;
        this.sum = sum;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
