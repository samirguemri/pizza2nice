package edu.samir.pizza2nice.model;


public abstract class Product implements IProduct{
    protected String name;
    protected String description;
    protected double price;

    protected Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() { return name; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }
}
