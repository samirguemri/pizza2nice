package edu.samir.pizza2nice.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Bill {
    private LocalUniqueId billRef;
    private LocalUniqueId orderRef;
    private Customer customer;
    private String orderDate;
    private List<Item> items;
    private DeliveryMode deliveryMode;
    private DeliveryMan deliveryMan;
    private double price;
    private int bonus;
    private boolean isPersistent;

    public Bill(Order order, DeliveryMode deliveryMode){
        this.billRef = LocalUniqueId.randomUniqueId();
        this.orderRef = order.getOrderRef();
        this.customer = order.getCustomer(); customer.addBill(this);
        this.orderDate = order.getOrderDate();
        this.items = order.getItems();
        this.deliveryMode = deliveryMode;
        this.price = calculatePrice();
        this.bonus = 0;
        this.isPersistent = false;
    }

    /*public Bill(Customer customer,List<Item> items, DeliveryMode deliveryMode){
        this.billRef = LocalUniqueId.randomUniqueId();
        this.customer = customer; customer.addBill(this);
        this.orderDate = LocalDateTime.now();
        this.items = items;
        this.deliveryMode = deliveryMode;
        this.price = calculatePrice();
        this.bonus = 0;
        this.isPersistent = false;
    }*/

    public Customer getCustomer() { return customer; }

    public String getOrderDate() { return orderDate; }

    public List<Item> getItems() { return items; }

    public void setDeliveryMan(DeliveryMan deliveryMan) {
        deliveryMan.addDeliveredBill(this);
        this.deliveryMan = deliveryMan;
    }

    public void setDeliveryMode(DeliveryMode deliveryMode) { this.deliveryMode = deliveryMode; }

    public DeliveryMode getDeliveryMode() { return deliveryMode; }

    public double getPrice() { return price; }

    private double calculatePrice() {
        if (items != null) {
            for (Item item : items)
                price += item.getPrice();
            price += getDeliveryCost();
            return price;
        }else
            return 0;
    }

    private double getDeliveryCost() {
        if(deliveryMode.equals(DeliveryMode.HOME_DELIVERY))
           return getDeliveryCostByArea();
        return 0;
    }

    private double getDeliveryCostByArea() {
        switch (customer.getArea()){
            case ZONE_A : return 3;
            case ZONE_B : return 4.5;
            case ZONE_C : return 6;
            case ZONE_D : return 7.5;
        }
        return 0;
    }

    public int getBonus(){ return bonus = Math.toIntExact((Math.round(price) / 10) * 2); }

    public LocalUniqueId getBillRef() { return billRef; }

    public void print() {
        // TO DO ..
    }
    public void toPdf(){
        // TO DO ..
    }
    public void send(){
        // TO DO ..
    }
}
