package edu.samir.pizza2nice.api.service.dessert;

import edu.samir.pizza2nice.api.dao.fake.dessert.IDessertDao;
import edu.samir.pizza2nice.model.Dessert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DessertService")
public class DessertServiceImpl implements IDessertService {

    private final IDessertDao dessertDao;

    @Autowired
    public DessertServiceImpl(@Qualifier("FakeDessertDao") IDessertDao dessertDao) {
        this.dessertDao = dessertDao;
    }

    @Override
    public void addNewDessert(Dessert newDessert) { dessertDao.insertNewDessert(newDessert);}

    @Override
    public Dessert selectDessertByIdName(String idName) {
        return dessertDao.selectDessertById(idName);
    }

    @Override
    public List<Dessert> selectDesserts() {
        return dessertDao.selectDesserts();
    }

    @Override
    public void updateDessertPriceByIdName(String idName, double newPrice) {
        dessertDao.updateDessertPriceByIdName(idName,newPrice);
    }

    @Override
    public void deleteDessertByIdName(String idName) { dessertDao.deleteDessertByIdName(idName);}
}
