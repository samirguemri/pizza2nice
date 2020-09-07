package edu.samir.pizza2nice.api.dao.fake.deliveryman;

import edu.samir.pizza2nice.exceptions.ExistingException;
import edu.samir.pizza2nice.model.DeliveryMan;


public interface IDeliveryManDao {
    void insertNewDeliveryMan(DeliveryMan newDeliveryMan);
    DeliveryMan selectDeliveryManById(String id);
    DeliveryMan selectAvailableDeliveryMan();
    void deleteDeliveryManByName(String firstName, String lastName);
    void assignDeliveryManScooterById(String idName) throws ExistingException;
}
