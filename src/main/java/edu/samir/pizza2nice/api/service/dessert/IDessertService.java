package edu.samir.pizza2nice.api.service.dessert;

import edu.samir.pizza2nice.model.Dessert;

import java.util.List;

public interface IDessertService {
    void addNewDessert(Dessert newDessert);
    Dessert selectDessertByIdName(String idName);
    List<Dessert> selectDesserts();
    void updateDessertPriceByIdName(String idName, double newPrice);
    void deleteDessertByIdName(String idName);
}
