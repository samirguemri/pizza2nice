package edu.samir.pizza2nice.api.dao.fake.scooter;

import edu.samir.pizza2nice.api.dao.fake.FakeDatabaseConnexionImpl;
import edu.samir.pizza2nice.model.Scooter;
import org.springframework.stereotype.Repository;

import java.util.Iterator;

@Repository("FakeScooterDao")
public class FakeScooterDaoImpl extends FakeDatabaseConnexionImpl implements IScooterDao {

    public FakeScooterDaoImpl() {
        super();
        connectToDatabase();
    }

    @Override
    public void insertNewScooter(Scooter newScooter) { scooterTable.put(newScooter.getPlateNumber(), newScooter); }

    @Override
    public void updateScooterAvailabilityByPlateNumber(String plateNumber, boolean availability) {
        Scooter scooter = scooterTable.get(plateNumber);
        scooter.setAvailability(availability);
        scooterTable.put(plateNumber,scooter);
    }

    @Override
    public void deleteScooterByPlateNumber(String plateNumber) { scooterTable.remove(plateNumber); }

    @Override
    public Scooter selectAvailableScooter() {
        Iterator<Scooter> scooterIterator = scooterTable.values().iterator();
        while (scooterIterator.hasNext()){
            Scooter scooter = scooterIterator.next();
            if (scooter.isAvailable())
                return scooter;
        }
        return null;
    }

    @Override
    public void makeScooterAvailableByPlateNumber(String plateNumber) {
        Scooter scooter = scooterTable.get(plateNumber);
        scooter.setAvailability(true);
        scooterTable.put(plateNumber,scooter);
    }
}
