package edu.samir.pizza2nice.api.dao.fake.dessert;

import edu.samir.pizza2nice.api.dao.fake.FakeDatabaseConnexionImpl;
import edu.samir.pizza2nice.model.Dessert;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("FakeDessertDao")
public class FakeDessertDaoImpl extends FakeDatabaseConnexionImpl implements IDessertDao {

    public FakeDessertDaoImpl() {
        super();
        connectToDatabase();
    }

    @Override
    public void insertNewDessert(Dessert newDessert) {
        dessertTable.put("D_"+newDessert.getName().replace(" ",""), newDessert);
    }

    @Override
    public Dessert selectDessertById(String idName) {
        return dessertTable.get(idName);
    }

    @Override
    public List<Dessert> selectDesserts() { return new ArrayList<>(dessertTable.values()); }

    @Override
    public void updateDessertPriceByIdName(String idName, double newPrice) {
        Dessert dessert = dessertTable.get(idName);
        dessert.setPrice(newPrice);
        dessertTable.put(idName,dessert);
    }

    @Override
    public void deleteDessertByIdName(String idName) { dessertTable.remove(idName); }
}
