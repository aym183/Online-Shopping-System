

import java.awt.Color;
import java.awt.Container;
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
//This is the page that appears when customer selects the CredtCard option in the checkout window
//The user will have to input Card Number and CVV to complete the transaction

//The class extends JFrame and implements ActionListener so when a button is clicked, there is an Action that in implemented
public class CreditCardWin extends JFrame implements ActionListener{

	//Initialisation of variables
	JTextField CredNo;
	JTextField CVV;
	JButton SubPay;
	JLabel Card;
	JLabel CVVLabel;
	JButton BackBtn = new JButton();
	JButton LogOut;
	Container NumCheck;

	// Initialisation of the final amount to be paid
	// Generalisation of class
	protected float resu;
	
	
	public CreditCardWin(float resu)  {
	
		this.resu = resu;
	
	}
	
	// Get method which returns the total amount to be paid
	public float getTotalVal() {
		return this.resu;
	}
	

	//This class handles the deeper specification of the initialised variables and formation of window
	public void operations(){
		
		// Specifications of the layout and design of the window
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setSize(420,420); 
		
		this.getContentPane().setBackground(new Color(0,255,255));
		
		// These are the specifications for the Label which asks user to enter Card Number
		Card = new JLabel("Card Number: ");
		Card.setFont(new Font("Verdana", Font.BOLD, 12));
		
		// These are the specifications for the TestField where user inputs Card Number
		CredNo = new JTextField (6);
		
		
		// These are the specifications for the Label which asks user to enter CVV
		CVVLabel = new JLabel("CVV: ");
		CVVLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		
		// These are the specifications for the TextField where user enters CVV
		CVV = new JTextField(3);
		
		
		// These are the specifications for the Button which user clicks when details have been entered to finalise payment
		SubPay = new JButton();
		SubPay.setBounds(100, 150, 150, 50);
		SubPay.setText("Confirm Payment");
		SubPay.setFocusable(false);
		SubPay.setBorder(BorderFactory.createEtchedBorder());
		SubPay.setBackground(Color.yellow);
		SubPay.setForeground(Color.blue);
		SubPay.addActionListener(this);
		
		
		// These are the specifications for the Button which user clicks to go to the previous window
		BackBtn.setBounds(100, 200, 150, 50);
		BackBtn.setText("Previous Window");
		BackBtn.setFocusable(false);
		BackBtn.setBorder(BorderFactory.createEtchedBorder());
		BackBtn.setBackground(Color.yellow);
		BackBtn.setForeground(Color.blue);
		BackBtn.addActionListener(this);
		
		// These are the specifications for the Button which user clicks when transaction completed and user wants to log out   
		LogOut = new JButton();
		LogOut.setBounds(100, 250, 150, 50);
		LogOut.setText("Log Out");
		LogOut.setFocusable(false);
		LogOut.setBorder(BorderFactory.createEtchedBorder());
		LogOut.setBackground(Color.yellow);
		LogOut.setForeground(Color.blue);
		LogOut.addActionListener(this);
		
		// This is the Container to which all the labels and textfields are added
		NumCheck = getContentPane();
		NumCheck.add(Card);
		NumCheck.add(CredNo);
		NumCheck.add(CVVLabel);
		NumCheck.add(CVV);
	   
	    
	    // Adding KyeListener which implements when user inputs in textfield. This is used to make sure that user inputs only numbers for Card Number
	    CredNo.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            String value = CredNo.getText();
	            int l = value.length();
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
	            	CredNo.setEditable(true);
	                
	            } else {
	            	CredNo.setEditable(false);
	            	JOptionPane.showMessageDialog(null,"Please enter only Numbers!");
	            }
	         }
	      });
	    
	 // Adding KyeListener which implements when user inputs in textfield. This is used to make sure that user inputs only numbers for CVV
	    CVV.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            String value = CVV.getText();
	            int l = value.length();
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
	            	CVV.setEditable(true);
	                
	            } else {
	            	CVV.setEditable(false);
	            	JOptionPane.showMessageDialog(null,"Please enter only Numbers!");
	            }
	         }
	      });
	    
	      setVisible(true);
	   
		// adding the remaining buttons
		
		this.add(SubPay);
		this.add(BackBtn);
		this.add(LogOut);
		
	
		this.setVisible(true);
		
		
}
	
	
	
	
	// Below is the functionality implemented when the buttons are clicked
	@Override
	public void actionPerformed(ActionEvent e) {
	
		// when 'Confirm Payment' button clicked, this is the functionality that takes place
		if(e.getSource()==SubPay) {
		
				// The conditional checks if the length of CVV and Card Number are 3 and 6 respectively
				// If valid, all the values will be logged

			//surrounded by try/catch to handle errors
				
				if(CVV.getText().length()== 3 && CredNo.getText().length()== 6 ) {
					
					//surrounded by try/catch to handle errors
					//try(BufferedWriter output = new BufferedWriter(new FileWriter("ActivityLog.txt", true))){
				    	 DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				    	 Date dateobj = new Date();
				    	 ViewBooks.Log2+= "purchased" + ", " + "Credit Card" + ", " + df.format(dateobj);
						 String NewLog = ViewBooks.Log2.toString();
						 ActivityLogCard log = new ActivityLogCard(resu, NewLog);
						 log.getString();
						//JOptionPane.showMessageDialog(null, this.getTotalVal() + " paid using Credit Card!");
						//output.append(Login.Log + ViewBooks.Log2.toString() + "\n");
					
				}
				
				// error statement if input is not of the desired length
				else {
					JOptionPane.showMessageDialog(this, 
							  "Please enter 3 digit CVV and 6 digit CardNumber", "Failure", JOptionPane.ERROR_MESSAGE);
				}
		
			
		}
		
		// when 'Log Out' button clicked, this is the functionality that takes place which takes user back to home page
		if(e.getSource()==LogOut) {
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to log out?","Warning",dialogButton);
			if(dialogResult == JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(null,"Logged Out successfully!");
				this.setVisible(false);
				Login newLogin = new Login();
				newLogin.LoginOperation();
				
			  
			}
			
		}
		
		// When 'Previous Window' Button is clickd, this is the functionality that is implemented
		if(e.getSource()==BackBtn) {
			this.setVisible(false);
		}
		
		
	}

	

	
}
