package CabInvoiceGenerator;

public class Ride {
	private double distance;
	private int time;
	private String rideType;
	
	public Ride(double distance,int time, String rideType) {
		this.distance=distance;
		this.time=time;
		this.rideType=rideType;
		
	}
	public String getRideType() {
		return rideType;
	}
	
	public double getDistance() {
		return distance;
	}
	
	public int getTime() {
		return time;
	}

}
