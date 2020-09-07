package edu.samir.pizza2nice.model;

public class Menu extends Item{
    //private double price;
    private int discount;

    public Menu(Order order, Product[] menu, int quantity){
        this.itemRef = LocalUniqueId.randomUniqueId();
        this.associatedOrder = order;
        this.product = new Product[]{menu[0], menu[1], menu[2]};
        this.quantity = quantity;
        this.discount = 10; // 10% DISCOUNT
        this.price = calculatePrice();
    }

    private double calculatePrice(){
    price = ( product[0].getPrice() + product[1].getPrice() + product[2].getPrice() ) * quantity;
        return price -= (price  * discount / 100); // IMPLEMENT 10% DISCOUNT
    }
}
