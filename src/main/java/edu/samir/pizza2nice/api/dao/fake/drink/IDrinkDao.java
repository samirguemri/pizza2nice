package edu.samir.pizza2nice.api.dao.fake.drink;

import edu.samir.pizza2nice.model.Drink;

import java.util.List;

public interface IDrinkDao {
    void insertNewDrink(Drink newDrink);
    Drink selectDrinkByIdName(String idName);
    List<Drink> selectDrinks();
    void updateDrinkPriceByIdName(String idName, double newPrice);
    void deleteDrinkByIdName(String idName);

}
