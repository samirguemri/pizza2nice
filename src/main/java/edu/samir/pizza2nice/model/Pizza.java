package edu.samir.pizza2nice.model;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends Product implements IProduct{
    private PizzaSize size;
    private Paste paste;
    private Sauce sauce;
    private List<Ingredient> ingredients;

    public Pizza(String name, String description, float price) {
        super(name, description, price);
        this.size = PizzaSize.MEDIUM;
        this.paste = Paste.CLASSIC;
        this.sauce = Sauce.TOMATO_SAUCE;
        this.ingredients = new ArrayList<>();
    }

    public PizzaSize getSize() { return size; }

    public void setSize(PizzaSize size) { this.size = size; }

    public Paste getPaste() { return paste; }

    public void setPaste(Paste paste) { this.paste = paste; }

    public Sauce getSauce() { return sauce; }

    public void setSauce(Sauce sauce) { this.sauce = sauce; }

    public List<Ingredient> getIngredients() { return ingredients; }

    public void addIngredients(Ingredient ingredient) { this.ingredients.add(ingredient); }

    @Override
    public double getPrice() {
        calculatePriceBySize();
        calculatePriceByPaste();
        calculatePriceByIngredients();
        return price;
    }

    private void calculatePriceBySize(){
        switch (size){
            case MEDIUM : price += (10 * 100) / price;
            case FAMILY : price += (20 * 100) / price;
            default : price += 0;
        }
    }

    private void calculatePriceByPaste() {
        switch (paste){
            case PAN : price += 1;
            case THICK : price += 2;
            case CHEESY : price += 3;
            default : price += 0;
        }
    }

    private void calculatePriceByIngredients(){ price += ingredients.size() - 2; } // les deux premiers ingredients au choix sont gratos

}
