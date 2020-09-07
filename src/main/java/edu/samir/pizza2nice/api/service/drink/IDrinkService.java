package edu.samir.pizza2nice.api.service.drink;

import edu.samir.pizza2nice.model.Drink;

import java.util.List;

public interface IDrinkService {
    void addNewDrink(Drink newDrink);
    List<Drink> selectDrinks();
    Drink selectDrinkByIdName(String idName);
    void updateDrinkPriceByIdName(String idName, double newPrice);
    void deleteDrinkByIdName(String idName);
}
