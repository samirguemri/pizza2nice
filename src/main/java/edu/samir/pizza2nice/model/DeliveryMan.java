package edu.samir.pizza2nice.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class DeliveryMan extends Person {
    private Map<LocalUniqueId, LocalDateTime> deliveredBills;
    private boolean available;
    private Scooter scooter;


    public DeliveryMan(String firstName, String lastName, String address, String zipCode){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.zipCode = zipCode;
        this.deliveredBills = new HashMap<>();
        this.available = true;
        this.scooter = null;
    }

    public boolean isAvailable() { return available; }

    public void setScooter(Scooter scooter) { this.scooter = scooter; }

    public void addDeliveredBill(Bill bill) { deliveredBills.put(bill.getBillRef(),LocalDateTime.now()); }
}
