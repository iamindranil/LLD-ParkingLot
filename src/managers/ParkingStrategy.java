package managers;

import models.ParkingSpot;
import models.Vehicle;
import java.util.List;

public interface ParkingStrategy {
    ParkingSpot findParkingSpot(List<ParkingSpot> spots, Vehicle vehicle);
}