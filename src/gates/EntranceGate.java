package gates;

import managers.ParkingSpotManager;
import managers.ParkingSpotManagerFactory;
import models.ParkingSpot;
import models.Ticket;
import models.Vehicle;
import enums.VehicleType;

import java.time.Instant;
import java.util.List;

public class EntranceGate {
    private ParkingSpotManagerFactory factory;

    public EntranceGate(ParkingSpotManagerFactory factory) {
        this.factory = factory;
    }

    public Ticket parkVehicle(Vehicle vehicle, List<ParkingSpot> spots) {
        ParkingSpotManager manager = factory.getParkingSpotManager(vehicle.getVehicleType(), spots);
        ParkingSpot spot = manager.findParkingSpot(vehicle);

        if (spot == null) {
            throw new RuntimeException("No parking spot available for the vehicle.");
        }

        manager.parkVehicle(vehicle);

        // Generate and return a parking ticket
        return generateTicket(vehicle, spot);
    }

    private Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        long entryTime = Instant.now().getEpochSecond(); // Current timestamp in seconds
        return new Ticket(entryTime, parkingSpot, vehicle);
    }
}
