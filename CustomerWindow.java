
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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

// Above are the imports
// This is the page that appears when one of the Customer users were selected in the home page
// The user will have the option of conducting transactions, viewing all books and cancelling transactions

// The class extends JFrame and implements ActionListener so when a button is clicked, there is an Action that in implemented
public class CustomerWindow extends Login implements ActionListener{
		
		//Initialisation of variables
		JButton ViewAllBooks = new JButton();
		JButton AddItemBasket = new JButton();
		JTextArea DisplayOrder = new JTextArea();
		JButton BackBtn = new JButton();
		
		//This class handles the deeper specification of the initialised variables and formation of window
		public CustomerWindow(){
			
		    // These are the specifications for the button that allows you to view all the books
			ViewAllBooks.setBounds(200, 100, 150, 50);
	 		ViewAllBooks.setText("View All Books");
	 		ViewAllBooks.setFocusable(false);
	 		ViewAllBooks.setBorder(BorderFactory.createEtchedBorder());
	 		ViewAllBooks.setBackground(Color.yellow);
	 		ViewAllBooks.setForeground(Color.blue);
	 		
	 		// These are the specifications for the Button which user clicks to go to the previous window
	 		BackBtn.setBounds(200, 300, 150, 50);
			BackBtn.setText("Previous Window");
			BackBtn.setFocusable(false);
			BackBtn.setBorder(BorderFactory.createEtchedBorder());
			BackBtn.setBackground(Color.yellow);
			BackBtn.setForeground(Color.blue);
	 		
	 		// These are the specifications for the button that allows you add book to cart
	 		AddItemBasket.setBounds(200, 200, 150, 50);
	 		AddItemBasket.setText("Add To Basket");
	 		AddItemBasket.setFocusable(false);
	 		AddItemBasket.setBorder(BorderFactory.createEtchedBorder());
	 		AddItemBasket.setBackground(Color.yellow);
	 		AddItemBasket.setForeground(Color.blue);
	 		
	 		// ActionListener being added to both buttons
	 		AddItemBasket.addActionListener(this);
	 		ViewAllBooks.addActionListener(this);
	 		BackBtn.addActionListener(this);
	 		
	 		// Specifications of the layout and design of the window
	 		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	 		this.setLayout(null);
	 		this.getContentPane().setBackground(new Color(0,255,255));
	 		this.setVisible(true);
	 		this.setSize(800,800); 
	 		this.add(ViewAllBooks);
	 		this.add(AddItemBasket);
	 		this.add(BackBtn);
	 		this.setVisible(true);
	 		
	 		
	 		
	 	}
		
		// Below is the functionality implemented when the buttons are clicked
		@Override
		public void actionPerformed(ActionEvent e) {
			
			// When the 'AddItemBasket' button is clicked, a new window opens which lets the user conduct transactions
			if(e.getSource()==AddItemBasket) {
				
				ViewBooks StockData2 = new ViewBooks();
					
			}
					
			// When the 'ViewAllBooks' button is clicked, a new window opens which lets the user View all the books and filter them by genre
			if(e.getSource()==ViewAllBooks) {
				
				ViewBooks StockData2 = new ViewBooks();
				StockData2.readArray("Stock.txt");
				StockData2.CheckoutProc.setEnabled(false);
				StockData2.AddToCart.setEnabled(false);
				StockData2.CancelCart.setEnabled(false);
				StockData2.AddtoBask.setEnabled(false);
				StockData2.BookType.setEnabled(false);
				
		
			        }
			
			// When 'Previous Window' Button is clickd, this is the functionality that is implemented
			if(e.getSource()==BackBtn) {
				this.setVisible(false);
				Login Log = new Login();
				Log.LoginOperation();
			}
			
	} 
}


