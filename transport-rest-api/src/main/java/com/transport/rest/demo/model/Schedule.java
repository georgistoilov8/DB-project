package com.transport.rest.demo.model;

import java.util.Date;
import java.util.List;

public class Schedule {
    int id;
    int lineId;
    int stopId;
    String season;
    String dayType;
    Date date;
    List<ArrivalTime> timeList;

    public Schedule() {
    }

    public Schedule(int id, int lineId, int stopId, String season, String dayType, Date date, List<ArrivalTime> timeList) {
        this.id = id;
        this.lineId = lineId;
        this.stopId = stopId;
        this.season = season;
        this.dayType = dayType;
        this.date = date;
        this.timeList = timeList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLineId() {
        return lineId;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
    }

    public int getStopId() {
        return stopId;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getDayType() {
        return dayType;
    }

    public void setDayType(String dayType) {
        this.dayType = dayType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<ArrivalTime> getTimeList() {
        return timeList;
    }

    public void setTimeList(List<ArrivalTime> timeList) {
        this.timeList = timeList;
    }
}
