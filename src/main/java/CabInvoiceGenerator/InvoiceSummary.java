package CabInvoiceGenerator;

public class InvoiceSummary {
	
	private double totalFare;
	private int rides;
	private Object averageFare;

	public InvoiceSummary(double totalFare, int rides) {
		this.totalFare=totalFare;
		this.rides=rides;
		this.averageFare=this.totalFare/this.rides;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((averageFare == null) ? 0 : averageFare.hashCode());
		result = prime * result + rides;
		long temp;
		temp = Double.doubleToLongBits(totalFare);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceSummary other = (InvoiceSummary) obj;
		if (averageFare == null) {
			if (other.averageFare != null)
				return false;
		} else if (!averageFare.equals(other.averageFare))
			return false;
		if (rides != other.rides)
			return false;
		if (Double.doubleToLongBits(totalFare) != Double.doubleToLongBits(other.totalFare))
			return false;
		return true;
	}

}
