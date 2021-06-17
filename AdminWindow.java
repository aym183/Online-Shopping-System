
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

// Above are the imports
// This is the page that appears when the admin user was selected in the home page
// The user will have the option of Adding a new book and viewing all books

//The class extends JFrame and implements ActionListener so when a button is clicked, there is an Action that in implemented
public class AdminWindow  extends Login implements ActionListener{
			
		//Initialisation of variables
		JButton AddNewBook = new JButton();
		JButton ViewBooks = new JButton();
		JButton BackBtn = new JButton();
		
		//This class handles the deeper specification of the initialised variables and formation of window
	public AdminWindow(){
		
		 		// These are the specifications for the button that allows you to view all the books
		 		ViewBooks.setBounds(200, 100, 150, 50);
		 		ViewBooks.setText("View Books");
		 		ViewBooks.setFocusable(false);
		 		ViewBooks.setBorder(BorderFactory.createEtchedBorder());
		 		ViewBooks.setBackground(Color.yellow);
		 		ViewBooks.setForeground(Color.blue);
		 		
		 		// These are the specifications for the button that allows you Add a new book
		 	    AddNewBook.setBounds(200, 200, 150, 50);
		 		AddNewBook.setText("Add New Book");
		 		AddNewBook.setFocusable(false);
		 		AddNewBook.setBorder(BorderFactory.createEtchedBorder());
		 		AddNewBook.setBackground(Color.yellow);
		 		AddNewBook.setForeground(Color.blue);
		 	
		 		// These are the specifications for the Button which user clicks to go to the previous window	
		 		BackBtn.setBounds(200, 300, 150, 50);
				BackBtn.setText("Previous Window");
				BackBtn.setFocusable(false);
				BackBtn.setBorder(BorderFactory.createEtchedBorder());
				BackBtn.setBackground(Color.yellow);
				BackBtn.setForeground(Color.blue);
				
				
		 		// ActionListener being added to both buttons
		 		ViewBooks.addActionListener(this);
		 		AddNewBook.addActionListener(this);
		 		BackBtn.addActionListener(this);
		 		
		 		// Specifications of the layout and design of the window
		 		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 		this.setLayout(null);
		 		this.setSize(800,800); 
		 		this.setVisible(true);
		 		this.getContentPane().setBackground(new Color(0,255,255));
		 		this.add(ViewBooks);
		 		this.add(AddNewBook);
		 		this.add(BackBtn);
		 	 	
	}
				// Below is the functionality implemented when the buttons are clicked
				
				public void actionPerformed(ActionEvent e) {
					// This is the functionality implemented when the 'ViewBooks' button is clicked
					if(e.getSource()==ViewBooks) {
					// The window where all the books can be viewed is shown when the button has been clicked
						ViewBooks StockData = new ViewBooks();
						
						
						StockData.readArray("Stock.txt");
						System.out.println(StockData.Stock.getText());
						// Disabling the user to edit the textfields or conduct transactions, just lets them filter the books by genre and view them
						StockData.CheckoutProc.setEnabled(false);
						StockData.AddToCart.setEnabled(false);
						StockData.CancelCart.setEnabled(false);
						StockData.AddtoBask.setEnabled(false);
						StockData.BookType.setEnabled(false);
					
					        }
					// This is the functionality implemented when the 'AddNewBook' button is clicked
					if(e.getSource()== AddNewBook) {
						// When button is clicked, A new window pops up where the user can add a new book
						this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						this.setSize(420,420);
						this.setVisible(true);
						this.dispose();
						AddBookAdmin NewAdBook = new AddBookAdmin();
		
					
					}
					
					// When 'Previous Window' Button is clicked, this is the functionality that is implemented
					
					if(e.getSource()==BackBtn) {
						this.setVisible(false);
						Login Log = new Login();
						Log.LoginOperation();
					}
					

					    }
				
}

					
							
					
				
	 

		

				
		 
		 
		



