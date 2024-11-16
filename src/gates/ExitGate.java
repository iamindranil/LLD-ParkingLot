package gates;

import managers.ParkingSpotManager;
import managers.ParkingSpotManagerFactory;
import models.ParkingSpot;
import models.Ticket;
import models.Vehicle;
import enums.VehicleType;

import java.time.Instant;
import java.util.List;
import java.time.Duration;

public class ExitGate {
    private ParkingSpotManagerFactory factory;

    public ExitGate(ParkingSpotManagerFactory factory) {
        this.factory = factory;
    }

    public void removeVehicle(Ticket ticket, List<ParkingSpot> spots) {
        ParkingSpotManager manager = factory.getParkingSpotManager(ticket.getVehicle().getVehicleType(), spots);
        manager.removeVehicle(ticket.getVehicle());

        // Calculate and display the parking fee
        long exitTime = Instant.now().getEpochSecond();
        long fee = calculateParkingFee(ticket.getEntryTime(), exitTime, ticket.getParkingSpot().getPrice());
        System.out.println("Vehicle removed. Parking Fee: $" + fee);
    }

    private long calculateParkingFee(long entryTime, long exitTime, int pricePerUnitTime) {
        long durationInSeconds = Duration.between(Instant.ofEpochSecond(entryTime), Instant.ofEpochSecond(exitTime)).toSeconds();
        long durationInHours = Math.max(1, (durationInSeconds + 3599) / 3600); // Round up to the next hour
        return durationInHours * pricePerUnitTime;
    }
}
