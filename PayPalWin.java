
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//Above are the imports
//This is the page that appears when customer selects the PayPal option in the checkout window
//The user will have to input their email to complete the transaction

//The class extends JFrame and implements ActionListener so when a button is clicked, there is an Action that in implemented

public class PayPalWin extends JFrame  implements ActionListener {
	
	//Initialisation of variables
	JTextField Email;
	JButton SubPay;
	public static float results;
	JButton LogOut;
	JButton BackBtn = new JButton();
	JLabel EmailLabel;
	
	public PayPalWin(float results) {
		this.results = results;
		
	}
	
	public Float getTotalVal() {
		return this.results;
	}
	//This class handles the deeper specification of the initialised variables and formation of window
	 public void operations() {
		// Specifications of the layout and design of the window
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setSize(420,420); 
		
		this.getContentPane().setBackground(new Color(0,255,255));
		
		
		// These are the specifications for the Label which asks user to enter email
		EmailLabel = new JLabel("Please enter email: ");
		EmailLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		
		// These are the specifications for the TextField where the user enters their email
		Email = new JTextField(10);
		
		
		
		
		
		// These are the specifications for the Button where the user submits their email
		SubPay = new JButton();
		SubPay.setBounds(100, 150, 150, 50);
		SubPay.setText("Confirm Payment");
		SubPay.setFocusable(false);
		SubPay.setBorder(BorderFactory.createEtchedBorder());
		SubPay.setBackground(Color.yellow);
		SubPay.setForeground(Color.blue);
		SubPay.addActionListener(this);
		
		
		// These are the specifications for the Button where the user logs out
		LogOut = new JButton();
		LogOut.setBounds(100, 250, 150, 50);
		LogOut.setText("Log Out");
		LogOut.setFocusable(false);
		LogOut.setBorder(BorderFactory.createEtchedBorder());
		LogOut.setBackground(Color.yellow);
		LogOut.setForeground(Color.blue);
		LogOut.addActionListener(this);
		
		// These are the specifications for the Button which user clicks to go to the previous window
		BackBtn.setBounds(100, 200, 150, 50);
		BackBtn.setText("Previous Window");
		BackBtn.setFocusable(false);
		BackBtn.setBorder(BorderFactory.createEtchedBorder());
		BackBtn.setBackground(Color.yellow);
		BackBtn.setForeground(Color.blue);
		BackBtn.addActionListener(this);
		
		this.add(EmailLabel);
		this.add(Email);
		this.add(SubPay);
		this.add(BackBtn);
		this.add(LogOut);
		this.setVisible(true);
		
		
}
	
	
	
		
	// Below is the functionality implemented when the buttons are clicked
	@Override
	public void actionPerformed(ActionEvent e) {
		//wow.setText("Payment Amount: " + Float.toString(results));
		if(e.getSource()==SubPay) {
			String get = Email.getText().toString();
			
			//validates if it is in email format
			
			 String EMAIL_PATTERN = 
					    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			 
					
			 if (get.matches(EMAIL_PATTERN)) {
			
			// if the payment is successful, all the details are added to the log file and user will be taken to home page
			//try(BufferedWriter output = new BufferedWriter(new FileWriter("ActivityLog.txt", true))){
		    	 DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		    	 Date dateobj = new Date();
		    	// try {
		    	ViewBooks.Log2+= "purchased" + ", " + "PayPal" + ", " + df.format(dateobj);
		    	String NewLog = ViewBooks.Log2;
		    
		    	PayPalLog Log = new PayPalLog();
		    	Log.PaymentLog();
				
			
		    
			 }
			 else {
				 JOptionPane.showMessageDialog(this, 
						  "Please enter valid email!", "Failure", JOptionPane.ERROR_MESSAGE);
			 }
				
				
			}
		
		
		if(e.getSource()==LogOut) {
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to log out?","Warning",dialogButton);
			if(dialogResult == JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(null, "Logged Out successfully!");
				this.setVisible(false);
				Login newLogin = new Login();
				newLogin.LoginOperation();
			  
			}
			
		}
		
		// When 'Previous Window' Button is clickd, this is the functionality that is implemented
		if(e.getSource()==BackBtn) {
			this.setVisible(false);
		}
		// TODO Auto-generated method stub
		
	}

}
