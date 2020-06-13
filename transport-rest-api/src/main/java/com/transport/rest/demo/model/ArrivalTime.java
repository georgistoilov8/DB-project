package com.transport.rest.demo.model;

public class ArrivalTime {
    int hour;
    int minute;

    public ArrivalTime() {
    }

    public ArrivalTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }
}
