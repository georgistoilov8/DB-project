package com.transport.rest.demo.model;

public class Vehicle {
    String brand;
    String model;
    String plateNumber;
    int seatCapacity;
    int standingCapacity;
    boolean hasAirConditioner;
    boolean hasWheelchairRamp;
    String type;
    int lineId;

    public Vehicle() {
    }

    public Vehicle(String brand, String model, String plateNumber, int seatCapacity, int standingCapacity, boolean hasAirConditioner, boolean hasWheelchairRamp, String type, int lineId) {
        this.brand = brand;
        this.model = model;
        this.plateNumber = plateNumber;
        this.seatCapacity = seatCapacity;
        this.standingCapacity = standingCapacity;
        this.hasAirConditioner = hasAirConditioner;
        this.hasWheelchairRamp = hasWheelchairRamp;
        this.type = type;
        this.lineId = lineId;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public void setStandingCapacity(int standingCapacity) {
        this.standingCapacity = standingCapacity;
    }

    public void setHasAirConditioner(boolean hasAirConditioner) {
        this.hasAirConditioner = hasAirConditioner;
    }

    public void setHasWheelchairRamp(boolean hasWheelchairRamp) {
        this.hasWheelchairRamp = hasWheelchairRamp;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public int getStandingCapacity() {
        return standingCapacity;
    }

    public boolean isHasAirConditioner() {
        return hasAirConditioner;
    }

    public boolean isHasWheelchairRamp() {
        return hasWheelchairRamp;
    }

    public String getType() {
        return type;
    }

    public int getLineId() {
        return lineId;
    }
}
