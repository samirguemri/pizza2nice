package edu.samir.pizza2nice.api.dao.fake.item;

import edu.samir.pizza2nice.api.dao.fake.FakeDatabaseConnexionImpl;
import edu.samir.pizza2nice.model.Item;
import edu.samir.pizza2nice.model.LocalUniqueId;
import org.springframework.stereotype.Repository;

@Repository("FakeItemDao")
public class FakeItemDaoImpl extends FakeDatabaseConnexionImpl implements IItemDao {

    public FakeItemDaoImpl() {
        super();
        connectToDatabase();
    }

    @Override
    public void insertNewItem(Item item) { itemTable.put(item.getItemRef(), item); }

    @Override
    public Item selectItemByRef(LocalUniqueId itemRef) { return itemTable.get(itemRef); }

    @Override
    public void updateItemQuantityByRef(LocalUniqueId itemId, int newQuantity) {
        Item item = itemTable.get(itemId);
        item.setQuantity(newQuantity);
        itemTable.put(itemId,item);
    }

    @Override
    public void deleteItemByRef(LocalUniqueId itemId) { itemTable.remove(itemId); }
}
