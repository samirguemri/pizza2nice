package edu.samir.pizza2nice.api.dao.fake.scooter;

import edu.samir.pizza2nice.model.Scooter;

public interface IScooterDao {
    void insertNewScooter(Scooter newScooter);
    Scooter selectAvailableScooter();
    void deleteScooterByPlateNumber(String plateNumber);
    void makeScooterAvailableByPlateNumber(String plateNumber);
    void updateScooterAvailabilityByPlateNumber(String plateNumber, boolean availability);
}
