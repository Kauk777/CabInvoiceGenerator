package CabInvoiceGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
	Map<String, ArrayList<Ride>> userRides=null;

	public RideRepository() {
		this.userRides=new HashMap<>();
	}

	public void addRides(String userId, Ride[] rides) {
		ArrayList<Ride> userList=this.userRides.get(userId);
		if(userList==null) {
			this.userRides.put(userId, new ArrayList<Ride>(Arrays.asList(rides)));
		}
		else
			this.userRides.put(userId, userList);
	}

	public Ride[] getRidesData(String userId) {
		Ride[] rideArr=new Ride[this.userRides.get(userId).size()];
		return this.userRides.get(userId).toArray(rideArr);
		
	}
	
	
	

}
