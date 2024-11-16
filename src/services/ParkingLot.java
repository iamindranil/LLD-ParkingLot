package services;

import java.util.List;

import models.ParkingFloor;
import models.ParkingSpot;
import models.Ticket;
import models.Vehicle;

public class ParkingLot {
	private List<ParkingFloor> floors;
	
	public ParkingLot() {
		this.floors=floors;
	}
	
	public void addFloor(ParkingFloor floor) {
		this.floors.add(floor);
	}
	
	public Ticket parkVehicle(Vehicle vehicle) {
		for(ParkingFloor floor:floors) {
			ParkingSpot spot=floor.findAvailableSpot();
			if(spot!=null) {
				spot.parkVehicle(vehicle);
				return new Ticket(System.currentTimeMillis(), spot, vehicle);
			}
		}
		return null;
	}
	
	public void removeVehicle(Ticket ticket) {
		ParkingSpot spot=ticket.getParkingSpot();
		spot.removeVehicle();
		
	}
	
}
