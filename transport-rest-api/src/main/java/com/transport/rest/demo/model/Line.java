package com.transport.rest.demo.model;

public class Line {
    int id;
    int number;
    int stopsCount;
    double distance;
    String type;

    public Line() {
    }

    public Line(int id, int number, int stopsCount, double distance, String type) {
        this.id = id;
        this.number = number;
        this.stopsCount = stopsCount;
        this.distance = distance;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setStopsCount(int stopsCount) {
        this.stopsCount = stopsCount;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public int getStopsCount() {
        return stopsCount;
    }

    public double getDistance() {
        return distance;
    }
}
