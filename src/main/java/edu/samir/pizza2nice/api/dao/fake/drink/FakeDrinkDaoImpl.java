package edu.samir.pizza2nice.api.dao.fake.drink;

import edu.samir.pizza2nice.api.dao.fake.FakeDatabaseConnexionImpl;
import edu.samir.pizza2nice.model.Drink;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("FakeDrinkDao")
public class FakeDrinkDaoImpl extends FakeDatabaseConnexionImpl implements IDrinkDao {

    public FakeDrinkDaoImpl() {
        super();
        connectToDatabase();
    }

    @Override
    public void insertNewDrink(Drink newDrink) { drinkTable.put("B_"+newDrink.getName().replace(" ",""), newDrink); }

    @Override
    public Drink selectDrinkByIdName(String idName) { return drinkTable.get(idName); }

    @Override
    public List<Drink> selectDrinks() { return new ArrayList<>(drinkTable.values()); }

    @Override
    public void updateDrinkPriceByIdName(String idName, double newPrice) {
        Drink drink = drinkTable.get(idName);
        drink.setPrice(newPrice);
        drinkTable.put(idName,drink);
    }

    @Override
    public void deleteDrinkByIdName(String idName) { drinkTable.remove(idName); }
}
