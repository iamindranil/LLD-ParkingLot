//package src;

import models.ParkingFloor;
import models.ParkingSpot;
import models.Ticket;
import models.Vehicle;
import services.ParkingLot;
import enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize parking floors and spots
        List<ParkingFloor>floors=new ArrayList<>();
        
        // Floor 1: 50 spots for Two-Wheelers (price = 10)
        List<ParkingSpot>spotsFloor1=new ArrayList<>();
        for (int i=1;i<=50;i++) {
            spotsFloor1.add(new ParkingSpot(i,10));
        }
        ParkingFloor floor1 = new ParkingFloor(1);
        
        // Floor 2: 50 spots for Four-Wheelers (price = 20)
        List<ParkingSpot> spotsFloor2 = new ArrayList<>();
        for (int i = 51; i <= 100; i++) {
            spotsFloor2.add(new ParkingSpot(i, 20));
        }
        ParkingFloor floor2 = new ParkingFloor(2);
        
        // Add floors to parking lot
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);

        // Example of parking and removing vehicles

        // Park a Two-Wheeler 
        Vehicle twoWheeler = new Vehicle(123, VehicleType.TwoWheeler);
        System.out.println("Parking Two-Wheeler with Vehicle Number: " + twoWheeler.getVehicleNo());
        Ticket twoWheelerTicket = parkingLot.parkVehicle(twoWheeler); // Automatically finds spot
        if (twoWheelerTicket != null) {
            System.out.println("Two-Wheeler parked at Spot ID: " + twoWheelerTicket.getParkingSpot().getId());
        } else {
            System.out.println("No parking spot available for the Two-Wheeler.");
        }

        // Remove the Two-Wheeler
        if (twoWheelerTicket != null) {
            System.out.println("Removing Two-Wheeler with Vehicle Number: " + twoWheeler.getVehicleNo());
            parkingLot.removeVehicle(twoWheelerTicket);
            System.out.println("Two-Wheeler removed from parking lot.");
        }

        // Park a Four-Wheeler
        Vehicle fourWheeler = new Vehicle(456, VehicleType.FourWheeler);
        System.out.println("\nParking Four-Wheeler with Vehicle Number: " + fourWheeler.getVehicleNo());
        Ticket fourWheelerTicket = parkingLot.parkVehicle(fourWheeler); // Automatically finds spot
        if (fourWheelerTicket != null) {
            System.out.println("Four-Wheeler parked at Spot ID: " + fourWheelerTicket.getParkingSpot().getId());
        } else {
            System.out.println("No parking spot available for the Four-Wheeler.");
        }

        // Remove the Four-Wheeler
        if (fourWheelerTicket != null) {
            System.out.println("Removing Four-Wheeler with Vehicle Number: " + fourWheeler.getVehicleNo());
            parkingLot.removeVehicle(fourWheelerTicket);
            System.out.println("Four-Wheeler removed from parking lot.");
        }
    }
}
