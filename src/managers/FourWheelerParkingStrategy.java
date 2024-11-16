package managers;

import models.ParkingSpot;
import models.Vehicle;
import java.util.List;

public class FourWheelerParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingSpot findParkingSpot(List<ParkingSpot> spots, Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.isEmpty() && spot.getPrice() == 20) { // Example condition for four-wheelers
                return spot;
            }
        }
        return null;
    }
}
