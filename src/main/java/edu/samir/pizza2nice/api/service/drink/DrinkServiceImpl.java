package edu.samir.pizza2nice.api.service.drink;

import edu.samir.pizza2nice.api.dao.fake.drink.IDrinkDao;
import edu.samir.pizza2nice.model.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DrinkService")
public class DrinkServiceImpl implements IDrinkService {

    private final IDrinkDao drinkDao;

    @Autowired
    public DrinkServiceImpl(@Qualifier("FakeDrinkDao") IDrinkDao drinkDao) {
        this.drinkDao = drinkDao;
    }

    @Override
    public void addNewDrink(Drink newDrink) {
        drinkDao.insertNewDrink(newDrink);
    }

    @Override
    public List<Drink> selectDrinks() { return drinkDao.selectDrinks(); }

    @Override
    public Drink selectDrinkByIdName(String idName) {
        return drinkDao.selectDrinkByIdName(idName);
    }

    @Override
    public void updateDrinkPriceByIdName(String idName, double newPrice) {
        drinkDao.updateDrinkPriceByIdName(idName,newPrice);
    }

    @Override
    public void deleteDrinkByIdName(String idName) {
        drinkDao.deleteDrinkByIdName(idName);
    }
}
