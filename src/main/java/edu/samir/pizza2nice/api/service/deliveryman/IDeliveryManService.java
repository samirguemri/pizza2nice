package edu.samir.pizza2nice.api.service.deliveryman;

import edu.samir.pizza2nice.exceptions.ExistingException;
import edu.samir.pizza2nice.model.DeliveryMan;

public interface IDeliveryManService {
    void addNewDeliveryMan(DeliveryMan newDeliveryMan);
    DeliveryMan getDeliveryManById(String id);
    DeliveryMan getAvailableDeliveryMan();
    void deleteDeliveryManByName(String firstName, String lastName);
    void assignDeliveryManScooterById(String idName) throws ExistingException, ExistingException;
}
