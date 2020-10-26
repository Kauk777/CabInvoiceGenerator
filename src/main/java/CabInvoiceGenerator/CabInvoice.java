package CabInvoiceGenerator;

public class CabInvoice {

	private RideRepository ridesRepository = null;

	public CabInvoice() {
		this.ridesRepository = new RideRepository();
	}

	public InvoiceSummary calculateInvoiceSummary(Ride[] rides) {
		double fare = CabRideMode.calculateFare(rides);
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
