package edu.samir.pizza2nice.api.service.scooter;

import edu.samir.pizza2nice.model.Scooter;
import org.springframework.stereotype.Service;

public interface IScooterService {
    void addNewScooter(Scooter newScooter);
    void deleteScooterByPlateNumber(String plateNumber);
    Scooter getAvailableScooter();
    void makeScooterAvailableByPlateNumber(String plateNumber);
    void updateScooterAvailabilityByPlateNumber(String plateNumber, boolean availability);
}
