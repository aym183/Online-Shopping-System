

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//Above are the imports
//This is the page that appears when the admin user clicks the 'Add new Book' button
//The user will have to fill in the required fields with the respective book details to add it

//The class extends JFrame and implements ActionListener so when a button is clicked, there is an Action that in implemented

public class AddBookAdmin extends JFrame implements ActionListener {
	
	//Initialisation of variables
	int l;
	JTextField BookISBN;
	JTextField BookTitle;
	JTextField BLanguage;
	JTextField BookGenre;
	JTextField BookReleaseDate;
	JTextField BookPrice;
	JTextField BookStock;
	JTextField AdditionalInfo1;
	JTextField AdditionalInfo2;
	JButton AddBookToStock;
	JButton BackBtn;
	JLabel GenreLabel;
	JLabel ISBNLabel;
	JLabel BookTypeLabel;
	JLabel BookTitleLabel;
	JLabel BLanguageLabel;
	JLabel BReleaseDateLabel;
	JLabel BookPriceLabel;
	JLabel BookStockLabel;
	JLabel AdditionalInfo1Label;
	JLabel AdditionalInfo2Label;
	JComboBox BookType;
	Container NumCheck;
	
	//This class handles the deeper specification of the initialised variables
	public AddBookAdmin(){
		
		
		// The JPanel details are listed below 
		JPanel red = new JPanel();
		red.setBackground(Color.red);
		red.setBounds(1,0,650,300);
		
		// The values for the JComboBox, I've used JComboBox for Book Type because there are only 3 possible values a user can enter
		String [] validusers = {"paperback", "audiobook", "ebook"};
		

		
		// The label and button for the TextField which takes the Book Genre
	 	GenreLabel = new JLabel("GENRE:", JLabel.LEFT);
	 	GenreLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		BookGenre = new JTextField(10);
		BookGenre.setBackground(Color.cyan);
		
		// The label and button for the TextField which takes the Book ISBN
		ISBNLabel = new JLabel("ISBN:");
		ISBNLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		BookISBN = new JTextField(10);
		BookISBN.setBackground(Color.cyan);
		
		// The label and button for the TextField which takes the Book Type
		BookTypeLabel = new JLabel("BOOK TYPE:");
		BookTypeLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		BookType = new JComboBox(validusers);
	
		
		// The label and button for the TextField which takes the Book Title
		BookTitleLabel = new JLabel("TITLE:");
		BookTitleLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		BookTitle = new JTextField(10);
		BookTitle.setBackground(Color.cyan);
		
		// The label and button for the TextField which takes the Book Language
		BLanguageLabel = new JLabel("LANGUAGE:");
		BLanguageLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		BLanguage = new JTextField(10);
		BLanguage.setBackground(Color.cyan);

		// The label and button for the TextField which takes the Book Release Date
		BReleaseDateLabel = new JLabel("RELEASE DATE(dd-mm-yyyy):");
		BReleaseDateLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		BookReleaseDate = new JTextField(10);
		BookReleaseDate.setBackground(Color.cyan);
		
		// The label and button for the TextField which takes the Book Price
		BookPriceLabel = new JLabel("PRICE:");
		BookPriceLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		BookPrice = new JTextField(10);
		BookPrice.setBackground(Color.cyan);
		
		// The label and button for the TextField which takes the Book Stock
		BookStockLabel = new JLabel("     STOCK:");
		BookStockLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		BookStock = new JTextField(10);
		BookStock.setBackground(Color.cyan);
		
		// The label and button for the TextField which takes the Book Additional Info 1
		AdditionalInfo1Label = new JLabel("ADDITIONAL INFO 1:");
		AdditionalInfo1Label.setFont(new Font("Verdana", Font.BOLD, 18));
		AdditionalInfo1 = new JTextField(10);
		AdditionalInfo1.setBackground(Color.cyan);
		
		// The label and button for the TextField which takes the Book Additioal Info 2;
		AdditionalInfo2Label = new JLabel("ADDITIONAL INFO 2:");
		AdditionalInfo2Label.setFont(new Font("Verdana", Font.BOLD, 18));
		AdditionalInfo2 = new JTextField(10);
		AdditionalInfo2.setBackground(Color.cyan);
		
		// These are the specifications for the button that adds the new book to the Stock text file
		AddBookToStock = new JButton();
		AddBookToStock.setBounds(200, 100, 150, 50);
		AddBookToStock.setText("Add To Stock");
		AddBookToStock.setFocusable(false);
		AddBookToStock.setBorder(BorderFactory.createEtchedBorder());
		AddBookToStock.setBackground(Color.yellow );
		AddBookToStock.setForeground(Color.blue);
		AddBookToStock.addActionListener(this);
		AddBookToStock.setFont(new Font("Verdana", Font.BOLD, 18));
		
		
		// These are the specifications for the Button which user clicks to go to the previous window	
		BackBtn =  new JButton();
		BackBtn.setBounds(200, 200, 150, 50);
		BackBtn.setText("Previous Window");
		BackBtn.setFocusable(false);
		BackBtn.setBorder(BorderFactory.createEtchedBorder());
		BackBtn.setBackground(Color.yellow);
		BackBtn.setForeground(Color.blue);
		BackBtn.addActionListener(this);
		BackBtn.setFont(new Font("Verdana", Font.BOLD, 18));
		
		NumCheck = getContentPane();
	
		NumCheck.add(BookISBN);
		NumCheck.add(BookStock);
		NumCheck.add(BookPrice);
		
		// These are the key listener's which validate if the user has entered a number in the required fields
		
		BookISBN.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            String value = BookISBN.getText();
	            l = value.length();
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
	            	BookISBN.setEditable(true);
	                
	            } else {
	            	BookISBN.setEditable(false);
	            	JOptionPane.showMessageDialog(null,"Please enter only Numbers!");
	            }
	         }
	      });
		
		// handles error if numbers not entered in ISBN and Stock field
		BookStock.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            String value = BookStock.getText();
	            l = value.length();
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
	            	BookStock.setEditable(true);
	                
	            } else {
	            	BookStock.setEditable(false);
	            	JOptionPane.showMessageDialog(null,"Please enter only Numbers!");
	            }
	         }
	      });
		
		BookPrice.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            String value = BookPrice.getText();
	            l = value.length();
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '.' ) {
	            	BookPrice.setEditable(true);
	                
	            } else {
	            	BookISBN.setEditable(false);
	            	JOptionPane.showMessageDialog(null,"Please enter decimal format price!");
	            }
	         }
	      });
		
		
	// Specifications of the layout and design of the window
	//this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	this.setLayout(null);
	this.setSize(650,300); 
	this.setVisible(true);
	this.getContentPane().setBackground(new Color(0,255,255));
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
	// JPanel and elements to be placed in JPanel being added
	this.add(red);
	red.add(GenreLabel);
	red.add(BookGenre);
	red.add(ISBNLabel);
	red.add(BookISBN);
	red.add(BookTypeLabel);
	red.add(BookType);
	red.add(BookTitleLabel);
	red.add(BookTitle);
	red.add(BLanguageLabel);
	red.add(BLanguage);
	red.add(BReleaseDateLabel);
	red.add(BookReleaseDate);
	red.add(BookPriceLabel);
	red.add(BookPrice);
	red.add(BookStockLabel);
	red.add(BookStock);
	red.add(AdditionalInfo1Label);
	red.add(AdditionalInfo1);
	red.add(AdditionalInfo2Label);
	red.add(AdditionalInfo2);
	red.add(AddBookToStock);
	red.add(BackBtn);
	
}
	//This class handles the deeper specification of the initialised variables and formation of window
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// All the inputs are being added into an arraylist below
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add(BookGenre.getText());
		list2.add(BookISBN.getText().toString());
		list2.add(BookType.getSelectedItem().toString());
		list2.add(BookTitle.getText());
		list2.add(BLanguage.getText());
		list2.add(BookReleaseDate.getText());
		list2.add(BookPrice.getText().toString());
		list2.add(BookStock.getText().toString());
		list2.add(AdditionalInfo1.getText());
	;
	
		// operation of adding book to Stock textfile takes place only when ISBN entered digits is 8
		if(e.getSource()==AddBookToStock) {
		if(BookISBN.getText().length()== 8 ) {
			
			// surrounded by try/catch to handle errors
			try(BufferedWriter output = new BufferedWriter(new FileWriter("Stock.txt", true))){
				
			    for (String item : list2) {
			          output.append(item + ", ");
			    }
			    output.append(AdditionalInfo2.getText());
			    output.append("\n");
			    
			    // message that is shown when book has been added successfully
			    JOptionPane.showMessageDialog(null, "You have successfully added a new book!");
	        


		}catch (IOException e1) {
	        System.out.println("Exception Occurred:");
	        e1.printStackTrace();
	    }
		}
			// error message if ISBN entered is not 8 digits 
			else {
				JOptionPane.showMessageDialog(this, 
						  "Please enter 8 digit ISBN ", "Failure", JOptionPane.ERROR_MESSAGE);
				
				
			}
			
		
		
		}
		
		if(e.getSource()==BackBtn) {
			this.setVisible(false);
			AdminWindow Previous = new AdminWindow();
			
		}
		
		
	
	}
}
	