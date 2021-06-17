import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
// the extension of the abstract class
public class FinalCancelLog extends CancelLogAb{
	private String LogDets;
	public FinalCancelLog(String date, String LogDets) {
		
		super(date);
		this.LogDets=LogDets;
		
	}
	public String getString2() {
		return this.LogDets;
	}

	// the override operation of the abstract subclass which logs the cancellation details
	@Override
	public void CancelLog() {
		try(BufferedWriter output = new BufferedWriter(new FileWriter("ActivityLog.txt", true))){
			
		output.append(Login.Log+ getString2()  + "\n");
		
    	
		}catch (IOException e1) {
			System.out.println("Exception Occurred:");
			e1.printStackTrace();

}
		
	}
}
