package CabInvoiceGenerator;

public enum CabRideMode {
	NORMAL(10, 1, 5), PREMIUM(15, 2, 20);

	public final double cost_perKm;
	public final int cost_perMin;
	public final double min_Fare;

	private CabRideMode(double cost_perKm, int cost_perMin, double min_Fare) {
		this.cost_perKm = cost_perKm;
		this.cost_perMin = cost_perMin;
		this.min_Fare = min_Fare;
	}

	public static double calculateFare(Ride[] rides) {
		double fare = 0;
		for (Ride ride : rides) {
			if (ride.rideMode.equals(NORMAL)) {
				fare = fare + (ride.getDistance() * NORMAL.cost_perKm + ride.getTime() * NORMAL.cost_perMin);
				fare = Math.max(fare, NORMAL.min_Fare);
			} else if (ride.rideMode.equals(PREMIUM)) {
				fare = fare + (ride.getDistance() * PREMIUM.cost_perKm + ride.getTime() * PREMIUM.cost_perMin);
				fare = Math.max(fare, NORMAL.min_Fare);
			}
		}
		return fare;
	}
}
