package edu.samir.pizza2nice.api.dao.fake.item;

import edu.samir.pizza2nice.model.Item;
import edu.samir.pizza2nice.model.LocalUniqueId;

public interface IItemDao {
    void insertNewItem(Item item);
    Item selectItemByRef(LocalUniqueId itemRef);
    void updateItemQuantityByRef(LocalUniqueId itemRef, int newQuantity);
    void deleteItemByRef(LocalUniqueId itemRef);
}
