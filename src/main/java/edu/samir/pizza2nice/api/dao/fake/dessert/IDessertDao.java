package edu.samir.pizza2nice.api.dao.fake.dessert;

import edu.samir.pizza2nice.model.Dessert;

import java.util.List;

public interface IDessertDao {
    void insertNewDessert(Dessert newDessert);
    Dessert selectDessertById(String idName);
    List<Dessert> selectDesserts();
    void updateDessertPriceByIdName(String idName, double newPrice);
    void deleteDessertByIdName(String idName);
}
