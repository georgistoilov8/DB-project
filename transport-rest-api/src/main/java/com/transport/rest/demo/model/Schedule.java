package com.transport.rest.demo.model;

import java.util.Date;
import java.util.List;

public class Schedule {
    int id;
    int lineId;
    int stopId;
    String type;
    Date date;
    List<ArrivalTime> timeList;

    public Schedule() {
    }

    public Schedule(int id, int lineId, int stopId, String type, Date date, List<ArrivalTime> timeList) {
        this.id = id;
        this.lineId = lineId;
        this.stopId = stopId;
        this.type = type;
        this.date = date;
        this.timeList = timeList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTimeList(List<ArrivalTime> timeList) {
        this.timeList = timeList;
    }

    public int getId() {
        return id;
    }

    public int getLineId() {
        return lineId;
    }

    public int getStopId() {
        return stopId;
    }

    public String getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public List<ArrivalTime> getTimeList() {
        return timeList;
    }
}
