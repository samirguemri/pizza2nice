package edu.samir.pizza2nice.api.service.scooter;

import edu.samir.pizza2nice.api.dao.fake.scooter.IScooterDao;
import edu.samir.pizza2nice.model.Scooter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ScooterService")
public class ScooterServiceImpl implements IScooterService {
    private final IScooterDao scooterDao;

    @Autowired
    public ScooterServiceImpl(@Qualifier("FakeScooterDao") IScooterDao scooterDao) {
        this.scooterDao = scooterDao;
    }

    @Override
    public void addNewScooter(Scooter newScooter) {
        scooterDao.insertNewScooter(newScooter);
    }

    @Override
    public void deleteScooterByPlateNumber(String plateNumber) {
scooterDao.deleteScooterByPlateNumber(plateNumber);
    }

    @Override
    public Scooter getAvailableScooter() {
        return scooterDao.selectAvailableScooter();
    }

    @Override
    public void makeScooterAvailableByPlateNumber(String plateNumber) {
        scooterDao.makeScooterAvailableByPlateNumber(plateNumber);
    }

    @Override
    public void updateScooterAvailabilityByPlateNumber(String plateNumber, boolean availability) {
        scooterDao.updateScooterAvailabilityByPlateNumber(plateNumber,availability);
    }
}
