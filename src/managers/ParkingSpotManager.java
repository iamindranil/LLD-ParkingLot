package managers;

import models.ParkingSpot;
import models.Vehicle;
import java.util.List;

public class ParkingSpotManager {
    private List<ParkingSpot> spots;
    private ParkingStrategy strategy;

    public ParkingSpotManager(List<ParkingSpot> spots, ParkingStrategy strategy) {
        this.spots = spots;
        this.strategy = strategy;
    }

    public ParkingSpot findParkingSpot(Vehicle vehicle) {
        return strategy.findParkingSpot(spots, vehicle);
    }

    public void parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findParkingSpot(vehicle);
        if (spot != null) {
            spot.parkVehicle(vehicle);
        } else {
            throw new RuntimeException("No available parking spot.");
        }
    }

    public void removeVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.getVehicle() != null && spot.getVehicle().equals(vehicle)) {
                spot.removeVehicle();
                return;
            }
        }
        throw new RuntimeException("Vehicle not found in parking lot.");
    }
}
