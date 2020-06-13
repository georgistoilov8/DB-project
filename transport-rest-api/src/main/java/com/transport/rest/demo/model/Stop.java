package com.transport.rest.demo.model;

public class Stop {
    int id;
    String address;
    double longitude;
    double latitude;
    boolean canChargeCard;

    public Stop() {
    }

    public Stop(int id, String address, double longitude, double latitude, boolean canChargeCard) {
        this.id = id;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.canChargeCard = canChargeCard;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setCanChargeCard(boolean canChargeCard) {
        this.canChargeCard = canChargeCard;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public boolean isCanChargeCard() {
        return canChargeCard;
    }
}
