package CabInvoiceGenerator;

public class Ride {
	private double distance;
	private int time;
	public CabRideMode rideMode;

	public Ride(double distance, int time, CabRideMode rideMode) {
		this.distance = distance;
		this.time = time;
		this.rideMode = rideMode;

	}

	public double getDistance() {
		return distance;
	}

	public int getTime() {
		return time;
	}

}
