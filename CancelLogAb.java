
// This class uses abstraction which handles the cancellation of an order
public abstract class CancelLogAb {
	private String date;
	public CancelLogAb(String date) {
		this.date = date;
	}
// Getter method for date
	public String getDate() {
		return this.date;
	}
	// abstract subclass that I override
	public abstract void CancelLog();
} 
