package edu.samir.pizza2nice.api.service.deliveryman;

import edu.samir.pizza2nice.api.dao.fake.deliveryman.IDeliveryManDao;
import edu.samir.pizza2nice.model.DeliveryMan;
import edu.samir.pizza2nice.exceptions.ExistingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("DeliveryManService")
public class DeliveryManServiceImpl implements IDeliveryManService {

    private IDeliveryManDao deliveryManDao;

    @Autowired
    public DeliveryManServiceImpl(@Qualifier("FakeDeliveryManDao") IDeliveryManDao deliveryManDao){
        this.deliveryManDao = deliveryManDao;
    }

    @Override
    public DeliveryMan getDeliveryManById(String id) {
        return deliveryManDao.selectDeliveryManById(id);
    }

    @Override
    public DeliveryMan getAvailableDeliveryMan() {
        return deliveryManDao.selectAvailableDeliveryMan();
    }

    @Override
    public void addNewDeliveryMan(DeliveryMan newDeliveryMan) {
        deliveryManDao.insertNewDeliveryMan(newDeliveryMan);
    }

    @Override
    public void deleteDeliveryManByName(String firstName, String lastName) {
        deliveryManDao.deleteDeliveryManByName(firstName,lastName);
    }

    @Override
    public void assignDeliveryManScooterById(String idName) throws ExistingException {
        deliveryManDao.assignDeliveryManScooterById(idName);
    }
}
