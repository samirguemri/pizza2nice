package edu.samir.pizza2nice.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private LocalUniqueId orderRef;
    private Customer customer;
    private String orderDate;
    private List<Item> items;

    public Order(Customer customer) {
        this.orderRef = LocalUniqueId.randomUniqueId();
        this.customer = customer;
        this.orderDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        items = new ArrayList<>();
    }

    public LocalUniqueId getOrderRef() {
        return orderRef;
    }

    public void setOrderRef(LocalUniqueId orderRef) {
        this.orderRef = orderRef;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String  orderDate) {
        this.orderDate = orderDate;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item){
        item.setAssociatedOrder(this);
        this.items.add(item);
    }
}
