package CabInvoiceGenerator;

public class CabInvoice {

	private static final double MINIMUM_COST_PERKM = 10;
	private static final int MINIMUM_COST_PERMIN = 1;
	private static final double MINIMUM_FARE = 5;
	private static final double PREMIUM_MINIMUM_COST_PERKM = 15;
	private static final int PREMIUM_MINIMUM_COST_PERMIN = 2;
	private static final double PREMIUM_MINIMUM_FARE = 20;
	private RideRepository ridesRepository = null;

	public CabInvoice() {
		this.ridesRepository = new RideRepository();
	}

	public double calculateNormalFare(double distance, int time) {
		double fare = (distance * MINIMUM_COST_PERKM) + (time * MINIMUM_COST_PERMIN);
		// Alternative: Math.max(fare,MINUMUM_FARE);
		return (fare < MINIMUM_FARE) ? MINIMUM_FARE : fare;
	}

	public double calculatePremiumFare(double distance, int time) {
		double fare = (distance * PREMIUM_MINIMUM_COST_PERKM) + (time * PREMIUM_MINIMUM_COST_PERMIN);
		return (fare < PREMIUM_MINIMUM_FARE) ? PREMIUM_MINIMUM_FARE : fare;
	}

	public double calculateFare(Ride[] rides) {
		double totalFare = 0;

		for (Ride ride : rides) {
			if (ride.getRideType().equals("NORMAL"))
				totalFare = totalFare + calculateNormalFare(ride.getDistance(), ride.getTime());
			else
				totalFare = totalFare + calculatePremiumFare(ride.getDistance(), ride.getTime());
		}
		return totalFare;
	}

	public InvoiceSummary calculateInvoiceSummary(Ride[] rides) {
		double fare = calculateFare(rides);
		return new InvoiceSummary(fare, rides.length);
	}

	public void addRides(String userId, Ride[] rides) {
		ridesRepository.addRides(userId, rides);

	}

	public InvoiceSummary getInvoiceSummary(String userId) {
		Ride[] rideData = ridesRepository.getRidesData(userId);
		return calculateInvoiceSummary(rideData);
	}

}
