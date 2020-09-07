package edu.samir.pizza2nice.api.dao.fake.pizza;

import edu.samir.pizza2nice.model.Pizza;

import java.util.List;

public interface IPizzaDao {
    void insertNewPizza(Pizza newPizza);
    Pizza selectPizzaByIdName(String pizzaName);
    void updatePizzaByIdName(String pizzaName, Pizza newPizza);
    void deletePizzaByIdName(String pizzaName);
    List<Pizza> selectAllPizza();
}
