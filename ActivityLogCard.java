

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
// Inheritance being used which logs credit card transaction to log file
public class ActivityLogCard extends CreditCardWin {
	private String details;
	// New specifications are added to the generalised class
	public ActivityLogCard(float resu, String details) {
		super(resu);
		this.details = details;
		// TODO Auto-generated constructor stub
	}
	
	// returns the information being logged
	
	public String Details() {
		return this.details;
	}
	
	// logs the data to the logfile
	public void getString() {
		// makes the card empty after transaction
		ViewBooks.Stock.selectAll();
		ViewBooks.Stock.replaceSelection("");
		ViewBooks.result = 0;
		ViewBooks.quantity= 1;
		
		
		try(BufferedWriter output = new BufferedWriter(new FileWriter("ActivityLog.txt", true))){
	    	 DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	    	 Date dateobj = new Date();
	    	 //ViewBooks.Log2+= "purchased" + ", " + "Credit Card" + ", " + df.format(dateobj);
	    	 
			JOptionPane.showMessageDialog(null, this.resu + " paid using Credit Card!");
				output.append(Login.Log +  Details() + "\n");
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  //ViewBooks.Log2.toString() + "\n");
		}
	

}

