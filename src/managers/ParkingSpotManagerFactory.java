package managers;

import enums.VehicleType;
import models.ParkingSpot;
import java.util.List;

public class ParkingSpotManagerFactory {
    public ParkingSpotManager getParkingSpotManager(VehicleType vehicleType, List<ParkingSpot> spots) {
        ParkingStrategy strategy;

        if (vehicleType == VehicleType.TwoWheeler) {
            strategy = new TwoWheelerParkingStrategy();
        } else if (vehicleType == VehicleType.FourWheeler) {
            strategy = new FourWheelerParkingStrategy();
        } else {
            throw new IllegalArgumentException("Unsupported vehicle type.");
        }

        return new ParkingSpotManager(spots, strategy);
    }
}
