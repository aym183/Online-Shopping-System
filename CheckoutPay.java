

import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//Above are the imports
//This is the page that appears when the customer wants to checkout
//The user will have the option of paying by Card or Paypal
//The class extends JFrame and implements ActionListener so when a button is clicked, there is an Action that in implemented
public class CheckoutPay extends JFrame implements ActionListener{
	
	//Initialisation of variables
	JButton CreditCard = new JButton();
	JButton PayPal = new JButton();
	JButton BackBtn = new JButton();
	float newResult;
	JLabel PaymentAmount;
	
	//This class handles the deeper specification of the initialised variables and formation of window
	public CheckoutPay(){
		
		
		
		// These are the specifications for the button that allows you to pay by Card
		CreditCard.setBounds(100, 100, 150, 50);
		CreditCard.setText("Credit Card");
		CreditCard.setFocusable(false);
		CreditCard.setBorder(BorderFactory.createEtchedBorder());
		CreditCard.setBackground(Color.yellow);
		CreditCard.setForeground(Color.blue);
	
		
		// These are the specifications for the button that allows you to pay by PayPal
		PayPal.setBounds(100, 200, 150, 50);
		PayPal.setText("PayPal");
		PayPal.setFocusable(false);
		PayPal.setBorder(BorderFactory.createEtchedBorder());
		PayPal.setBackground(Color.yellow);
		PayPal.setForeground(Color.blue);
		
		BackBtn.setBounds(100, 300, 150, 50);
		BackBtn.setText("Previous Window");
		BackBtn.setFocusable(false);
		BackBtn.setBorder(BorderFactory.createEtchedBorder());
		BackBtn.setBackground(Color.yellow);
		BackBtn.setForeground(Color.blue);
		
		// Specifications of the layout and design of the window
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(0,255,255));
		this.setSize(420,420); 
		this.setVisible(true);              
		this.add(CreditCard);
 		this.add(PayPal);
 		this.add(BackBtn);
 		//this.add(PaymentAmount);
		
	// These are the ActionListeners implemented to the buttons 
 		CreditCard.addActionListener(this);
 		PayPal.addActionListener(this); 
 		BackBtn.addActionListener(this);
		
	
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// If CreditCard button is clicked, it opens up a new window
		if(e.getSource()==CreditCard) {
			CreditCardWin credCard2 = new CreditCardWin(newResult);
			credCard2.operations();
			
			//credCard2.resu= newResult;
		}
		
		// If PayPal button is clicked, it opens a new window
		if(e.getSource()==PayPal) {
			PayPalWin payPal2 = new PayPalWin(newResult);
			payPal2.operations();
			
			//payPal2.results= newResult;
		}
		if(e.getSource()==BackBtn) {
			
			this.setVisible(false);
			
			/*ViewBooks StockData2 = new ViewBooks();
			StockData2.setVisible(true);*/
		}
	}
		
	}
		
		
		
		
	
	


