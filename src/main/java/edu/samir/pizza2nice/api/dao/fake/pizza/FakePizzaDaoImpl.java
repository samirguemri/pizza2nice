package edu.samir.pizza2nice.api.dao.fake.pizza;

import edu.samir.pizza2nice.api.dao.fake.FakeDatabaseConnexionImpl;
import edu.samir.pizza2nice.model.Pizza;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("FakePizzaDao")
public class FakePizzaDaoImpl extends FakeDatabaseConnexionImpl implements IPizzaDao {

    public FakePizzaDaoImpl() {
        super();
        connectToDatabase();
    }

    @Override
    public void insertNewPizza(Pizza newPizza) {
        pizzaTable.put("P_"+newPizza.getName().replace(" ",""),newPizza);
    }

    @Override
    public Pizza selectPizzaByIdName(String pizzaNameId) { return pizzaTable.get(pizzaNameId); }

    @Override
    public void updatePizzaByIdName(String pizzaNameId, Pizza newPizza) { pizzaTable.put(pizzaNameId,newPizza); }

    @Override
    public void deletePizzaByIdName(String pizzaNameId) { pizzaTable.remove(pizzaNameId); }

    @Override
    public List<Pizza> selectAllPizza() {
        return new ArrayList<>(pizzaTable.values());
    }
}
