package edu.samir.pizza2nice.model;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person{
    protected LocalUniqueId id;
    private String addressNote;
    private Area area;
    private int loyaltyPoints;
    private List<Bill> bills;

    public Customer(LocalUniqueId id, String firstName, String lastName, String address, String zipCode, String addressNote) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.zipCode = zipCode;
        this.addressNote = "";
        this.loyaltyPoints = 0;
        this.area = null; setArea();
        bills = new ArrayList<>();
    }
    public void setBonus(int bonus) {
        loyaltyPoints += bonus;
    }

    private void setArea() {
        switch (zipCode){
            case "06000" :
            case "06100" :
                area = Area.ZONE_A; break;

            case "06200" :
            case "06300" :
                area = Area.ZONE_B; break;

            case "06610" :
            case "06700" :
            case "06800" :
                area = Area.ZONE_C; break;

            case "06730" :
            case "06950" :
            case "06670" :
            case "06790" :
                area = Area.ZONE_D; break;

            default : area = Area.HORS_ZONE;
        }
    }

    public LocalUniqueId getId() { return id; }

    public String getAddressNote() { return addressNote; }

    public Area getArea() { return area; }

    public int getLoyaltyPoints() { return loyaltyPoints; }

    public List<Bill> getBills() { return bills; }

    public void addBill(Bill bill){ this.bills.add(bill); }
}
