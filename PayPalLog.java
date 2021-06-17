

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
//This is the implementation of the interface used to log the payment details to log file

public class PayPalLog implements PayPalInterface{

	//The class is being override below
	
	@Override
	public void PaymentLog() {
		// makes the cart empty after transaction
		ViewBooks.Stock.selectAll();
		ViewBooks.Stock.replaceSelection("");
		
		//Surrounded by try/catch to handle errors
		try(BufferedWriter output = new BufferedWriter(new FileWriter("ActivityLog.txt", true))){
	    	 DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	    	 Date dateobj = new Date();
	    	
	    	 
			JOptionPane.showMessageDialog(null, PayPalWin.results + " paid using PayPal!");
			
			// Data being logged to log file
			output.append(Login.Log + ViewBooks.Log2 + "\n"); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		// TODO Auto-generated method stub
		
	}

}
