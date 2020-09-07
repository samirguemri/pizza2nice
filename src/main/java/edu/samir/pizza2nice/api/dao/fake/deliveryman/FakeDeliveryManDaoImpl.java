package edu.samir.pizza2nice.api.dao.fake.deliveryman;

import edu.samir.pizza2nice.api.dao.fake.FakeDatabaseConnexionImpl;
import edu.samir.pizza2nice.model.DeliveryMan;
import edu.samir.pizza2nice.model.Scooter;
import org.springframework.stereotype.Repository;

import java.util.Iterator;

@Repository("FakeDeliveryManDao")
public class FakeDeliveryManDaoImpl extends FakeDatabaseConnexionImpl implements IDeliveryManDao {

    public FakeDeliveryManDaoImpl() {
        super();
        connectToDatabase();
    }

    @Override
    public DeliveryMan selectDeliveryManById(String idName) {
        return deliveryManTable.get(idName);
    }

    @Override
    public DeliveryMan selectAvailableDeliveryMan() {
        Iterator<DeliveryMan> deliveryManIterator = deliveryManTable.values().iterator();
        while (deliveryManIterator.hasNext()){
            DeliveryMan deliveryMan = deliveryManIterator.next();
            if(deliveryMan.isAvailable())
                return deliveryMan;
        }
        return null;
    }

    @Override
    public void insertNewDeliveryMan(DeliveryMan newDeliveryMan) {
        String idName = newDeliveryMan.getFirstName().concat( newDeliveryMan.getLastName() );
        deliveryManTable.put(idName,newDeliveryMan);
    }

    @Override
    public void deleteDeliveryManByName(String firstName, String lastName) {
        String idName = firstName.concat(lastName);
        deliveryManTable.remove(idName);
    }

    @Override
    public void assignDeliveryManScooterById(String idName) throws edu.samir.pizza2nice.exceptions.ExistingException {
        Scooter availableScooter = null;
                DeliveryMan deliveryMan = deliveryManTable.get(idName);
        Iterator<Scooter> scooterIterator = scooterTable.values().iterator();
        while (scooterIterator.hasNext()){
            availableScooter = scooterIterator.next();
            if(availableScooter.isAvailable())
                break;
        }
        if(availableScooter != null)
            deliveryMan.setScooter(availableScooter);
        else
            throw new edu.samir.pizza2nice.exceptions.ExistingException("No Available Scooter .. Can't Assign Scooter ");
        deliveryManTable.put(idName,deliveryMan);
    }
}
