package models;

public class ParkingSpot {
	private int id;
	private boolean isEmpty;
	private Vehicle vehicle;
	private int price;
	
	public ParkingSpot(int id,int price) {
		this.id=id;
		this.isEmpty=true;
		this.vehicle=null;
		this.price=price;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean isEmpty() {
		return isEmpty;
	}
	
	public void parkVehicle(Vehicle v) {
		this.vehicle=v;
		this.isEmpty=false;
	}
	
	public void removeVehicle() {
        this.vehicle = null;
        this.isEmpty = true;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getPrice() {
        return price;
    }
}

