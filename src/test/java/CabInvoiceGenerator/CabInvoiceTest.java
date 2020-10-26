package CabInvoiceGenerator;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class CabInvoiceTest {

	CabInvoice invoice = null;

	@Before
	public void initialize_object() {
		invoice = new CabInvoice();
	}

	@Test
	public void given_distance_Generate_total_fare() {
		Ride[] rides = { new Ride(5.0, 20, CabRideMode.NORMAL) };
		double fare = CabRideMode.calculateFare(rides);
		Assert.assertEquals(70, fare, 0.0);
	}

	@Test
	public void given_smalldistance_shouldfail_minimumfare() {
		Ride[] rides = { new Ride(0.2, 2, CabRideMode.NORMAL) };
		double fare = CabRideMode.calculateFare(rides);
		Assert.assertEquals(5, fare, 0.0);
	}

	@Test
	public void given_multipleRide_shouldreturn_totalfare() {
		Ride[] rides = { new Ride(2.0, 5, CabRideMode.NORMAL), new Ride(4.0, 5, CabRideMode.NORMAL),
				new Ride(7.0, 3, CabRideMode.NORMAL) };
		double fare = CabRideMode.calculateFare(rides);
		Assert.assertEquals(143, fare, 0.0);
	}

	@Test
	public void given_multipleRide_shouldreturn_InvoiceSummary() {
		Ride[] rides = { new Ride(2.0, 5, CabRideMode.NORMAL), new Ride(4.0, 5, CabRideMode.NORMAL),
				new Ride(7.0, 3, CabRideMode.NORMAL) };
		InvoiceSummary expectedSummary = new InvoiceSummary(143, 3);
		InvoiceSummary summary = invoice.calculateInvoiceSummary(rides);
		Assert.assertEquals(expectedSummary, summary);
	}

	@Test
	public void givenUserId_shouldReturnInvoiceSummary() {
		String userId = "kauk.kky";
		Ride[] rides = { new Ride(2.0, 5, CabRideMode.NORMAL), new Ride(4.0, 5, CabRideMode.NORMAL),
				new Ride(7.0, 3, CabRideMode.NORMAL) };
		invoice.addRides(userId, rides);
		InvoiceSummary summary = invoice.getInvoiceSummary(userId);
		InvoiceSummary expectedSummary = new InvoiceSummary(143, 3);
		Assert.assertEquals(expectedSummary, summary);
	}

	@Test
	public void givenUserId_WhenPremiumOrNormalType_shouldReturnInvoiceSummary() {
		String userId = "kauk.kky";
		Ride[] rides = { new Ride(2.0, 5, CabRideMode.PREMIUM), new Ride(4.0, 5, CabRideMode.NORMAL),
				new Ride(1.0, 3, CabRideMode.PREMIUM) };
		invoice.addRides(userId, rides);
		InvoiceSummary summary = invoice.getInvoiceSummary(userId);
		InvoiceSummary expectedSummary = new InvoiceSummary(106, 3);
		Assert.assertEquals(expectedSummary, summary);
	}

}
