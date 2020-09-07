package edu.samir.pizza2nice.api.service.pizza;

import edu.samir.pizza2nice.model.Pizza;

import java.util.List;

public interface IPizzaService {
    void addNewPizza(Pizza newPizza);
    Pizza getPizzaByIdName(String pizzaName);
    List<Pizza> getAllPizza();
    void updatePizzaByIdName(String pizzaName, Pizza newPizza);
    void deletePizzaByIdName(String pizzaName);
}
