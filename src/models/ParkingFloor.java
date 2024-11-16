package models;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
	private int floorNumber;
	private List<ParkingSpot>spots;
	
	public ParkingFloor(int floorNumber) {
		this.floorNumber=floorNumber;
		this.spots=new ArrayList<>();
	}
	
	public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public void addParkingSpot(ParkingSpot spot) {
        this.spots.add(spot);
    }

    public ParkingSpot findAvailableSpot() {
        for (ParkingSpot spot : spots) {
            if (spot.isEmpty()) {
                return spot;
            }
        }
        return null; // No available spots
    }
}
