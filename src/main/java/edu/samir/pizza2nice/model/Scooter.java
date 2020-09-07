package edu.samir.pizza2nice.model;


public class Scooter {
    private String plateNumber;
    private boolean available;

    public Scooter(String plateNumber, boolean available) {
        this.plateNumber = plateNumber;
        this.available = available;
    }

    public String getPlateNumber() { return plateNumber; }

    public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }

    public boolean isAvailable() { return available; }

    public void setAvailability(boolean available) { this.available = available; }
}
