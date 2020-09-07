package edu.samir.pizza2nice.api.service.pizza;

import edu.samir.pizza2nice.api.dao.fake.pizza.IPizzaDao;
import edu.samir.pizza2nice.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PizzaService")
public class PizzaServiceImpl implements IPizzaService {

    private final IPizzaDao pizzaDao;

    @Autowired
    public PizzaServiceImpl(@Qualifier("FakePizzaDao") IPizzaDao pizzaDao) {
        this.pizzaDao = pizzaDao;
    }

    @Override
    public void addNewPizza(Pizza newPizza) {
        pizzaDao.insertNewPizza(newPizza);
    }

    @Override
    public Pizza getPizzaByIdName(String pizzaName) {
        return pizzaDao.selectPizzaByIdName(pizzaName);
    }

    @Override
    public List<Pizza> getAllPizza() { return pizzaDao.selectAllPizza(); }

    @Override
    public void updatePizzaByIdName(String pizzaName, Pizza newPizza) {
        pizzaDao.updatePizzaByIdName(pizzaName,newPizza);
    }

    @Override
    public void deletePizzaByIdName(String pizzaName) {
        pizzaDao.deletePizzaByIdName(pizzaName);
    }
}
