package managers;

import models.ParkingSpot;
import models.Vehicle;
import java.util.List;

public class TwoWheelerParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingSpot findParkingSpot(List<ParkingSpot> spots, Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.isEmpty() && spot.getPrice() == 10) { // Example condition for two-wheelers
                return spot;
            }
        }
        return null;
    }
}
