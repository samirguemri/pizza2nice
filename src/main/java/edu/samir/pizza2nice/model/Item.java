package edu.samir.pizza2nice.model;

public class Item {
    protected LocalUniqueId itemRef;
    protected Order associatedOrder;
    protected Product[] product;
    protected int quantity;
    protected double price;

    public Item() {}

    public Item(Product[] productRef, int quantity){
        this.itemRef = LocalUniqueId.randomUniqueId();
        this.associatedOrder = null;
        this.product = new Product[]{productRef[0]};
        this.quantity = quantity;
        this.price = product[0].price;
    }

    public LocalUniqueId getItemRef() { return itemRef; }

    public void setItemRef(LocalUniqueId itemRef) { this.itemRef = itemRef; }

    public Order getAssociatedOrderRef() { return associatedOrder; }

    public void setAssociatedOrder(Order associatedOrder) { this.associatedOrder = associatedOrder; }

    public Product[] getProduct() { return product; }

    public void setProduct(Product[] product) { this.product = product; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void setPrice(double price) { this.price = price; }

    public double getPrice(){ return price; }
}
