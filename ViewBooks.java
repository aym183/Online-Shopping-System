

import java.awt.Color;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

//Above are the imports
//This is the page that appears when the admin user clicks the 'View Books' button or customer clicks the 'View Books' or 'Add To Basket' buttons


//The class extends JFrame and implements ActionListener so when a button is clicked, there is an Action that in implemented

public class ViewBooks extends JFrame  implements ActionListener{
	
	//Initialisation of variables
	static JTextArea Stock;
	JTextField AddtoBask;
	JButton CheckoutProc;
	JButton CancelCart;
	JButton FilterGenre;
	JComboBox BookType;
	JButton AddToCart;
	JButton BackBtn;
	ArrayList<String> list = new ArrayList<String>();
	private String[] line;
	ArrayList<String> list2 = new ArrayList<String>();
	ArrayList<String> MultipleBooks = new ArrayList<String>();
	Scanner s;
	Scanner v;
	public static String Log2;
	public static float result = 0;
	private int i;
	public static int quantity = 1;
	private String response;

	
	//This class handles the deeper specification of the initialised variables and formation of window
	public ViewBooks(){
		
		 result = 0;
		String [] validusers = {"paperback", "audiobook", "ebook"};
		//This is the the label and  Textfield that requires the user to enter the Book Title
		JLabel BookTitle = new JLabel("BOOK TITLE:");
		BookTitle.setFont(new Font("Verdana", Font.BOLD, 10));
		
		AddtoBask = new JTextField(10);
		
		//This is the the label and  Textfield that requires the user to enter the Book Type
		JLabel BookTypeLabel = new JLabel("BOOK TYPE:");
		BookTypeLabel.setFont(new Font("Verdana", Font.BOLD, 10));
		BookType = new JComboBox(validusers);
		
		
		// These are the specifications for the button that allows you Add a book to cart
		AddToCart = new JButton();
		AddToCart.addActionListener(this);
		AddToCart.setBounds(100, 100, 150, 50);
		AddToCart.setText("Add To Cart");
		AddToCart.setFocusable(false);
		AddToCart.setBorder(BorderFactory.createEtchedBorder());
		AddToCart.setBackground(Color.yellow);
		AddToCart.setForeground(Color.blue);
		
		// These are the specifications for the button that allows you to checkout
		CheckoutProc = new JButton();
		CheckoutProc.addActionListener(this);
		CheckoutProc.setBounds(100, 150, 150, 50);
		CheckoutProc.setText("Proceed to Checkout");
		CheckoutProc.setFocusable(false);
		CheckoutProc.setBorder(BorderFactory.createEtchedBorder());
		CheckoutProc.setBackground(Color.yellow);
		CheckoutProc.setForeground(Color.blue);
		
		
		// These are the specifications for the button that allows you to cancel transaction
		CancelCart = new JButton();
		CancelCart.addActionListener(this);
		CancelCart.setBounds(100, 200, 150, 50);
		CancelCart.setText("Cancel Items In Cart");
		CancelCart.setFocusable(false);
		CancelCart.setBorder(BorderFactory.createEtchedBorder());
		CancelCart.setBackground(Color.yellow);
		CancelCart.setForeground(Color.blue);
		
		// These are the specifications for the button that allows you to filter books on gere
		FilterGenre = new JButton();
		FilterGenre.addActionListener(this);
		FilterGenre.setBounds(100, 250, 150, 50);
		FilterGenre.setText("Filter by Genre");
		FilterGenre.setFocusable(false);
		FilterGenre.setBorder(BorderFactory.createEtchedBorder());
		FilterGenre.setBackground(Color.yellow);
		FilterGenre.setForeground(Color.blue);
		

		// These are the specifications for the Button which user clicks to go to the previous window	
		BackBtn =  new JButton();
		BackBtn.setBounds(200, 200, 150, 50);
		BackBtn.setText("Previous Window");
		BackBtn.setFocusable(false);
		BackBtn.setBorder(BorderFactory.createEtchedBorder());
		BackBtn.setBackground(Color.yellow);
		BackBtn.setForeground(Color.blue);
		BackBtn.addActionListener(this);
		
		
		// adding everything to the JFrame
		this.add(BookTitle);
		this.add(AddtoBask);
		this.add(BookTypeLabel);
		this.add(BookType);
		this.add(AddToCart);
		this.add(CancelCart);
		this.add(CheckoutProc);
		this.add(FilterGenre);
		this.add(BackBtn);
		
		
		// Specificiations for the design and implementation of the JTextArea
		Stock = new JTextArea();
		this.add(Stock);
		Stock.setLineWrap(true);
		Stock.setWrapStyleWord(true); 
		Stock.setBackground(new Color(0,255,255));
		Stock.setEditable(false);
		Stock.setBounds(50, 50, 1000, 500);
		JScrollPane Scrolls = new JScrollPane(Stock);
		Scrolls.setPreferredSize(new Dimension(900,500));
		Scrolls.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		// Specifications of the layout and design of the window
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setSize(420,420); 
		this.getContentPane().setBackground(new Color(0,255,255));
		this.add(Scrolls);
		this.setVisible(true);

		
	
	}
	
	
	// this is the class that gets implemented when the ViewBooks button has been clicked by either Admin or Customer users
	public void readArray(String file) {
		int uhm = 0;
		Scanner s;
		
		// Surrounded by try/catch to handle errors
		
		// reads the text file and adds it to an arraylist which then gets added to the JTextArea
		try {
			s = new Scanner(new File(file));
			
			while (s.hasNext())
			{
			    list.add(s.nextLine());
			    
			}
			//Collections.sort(list);
			Stock.append(String.join("\n", list));
			
			
			s.close();
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}


	// Below is the functionality implemented when the buttons are clicked
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String text = AddtoBask.getText();
		
		/* when 'Proceed to Checkout' button has been clicked, the total amount to be paid is shown and takes the user to another window
			where they can finalise their transactions
		*/
		if(e.getSource()==CheckoutProc) {
			
			//error message when cart is empty
			if(Stock.getText().trim().length()== 0) {
				JOptionPane.showMessageDialog(this, 
						  "Empty cart, please add something to cart to checkout!", "Failure", JOptionPane.ERROR_MESSAGE);
				
			}
			else {
			
			JOptionPane.showMessageDialog(null, "The Amount to be paid is " + result);
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to checkout?","Warning",dialogButton);
			if(dialogResult == JOptionPane.YES_OPTION){
				
				CheckoutPay finalPay = new CheckoutPay();
				finalPay.newResult = result;
				
			
			}
			
			}
		
		}
		
		/*
		 * When the 'Filter By Genre' button is clicked, it filters the list of all books by Genre,
		 * I've used Collections.sort() to sortm my list and since it sorts based on the first element of each list,
		 * I had to edit the order of a textfile, Apologies.
		 */
		
		
		 if(e.getSource()==FilterGenre) {
			
			 // This code helps remove all the content, if any, from the JTextArea
			Stock.selectAll();
			Stock.replaceSelection("");
			
			
			boolean Payment = true;
			ArrayList<String> list2 = new ArrayList<String>();
			int uhm = 0;
			Scanner s;
			
			// Surrounded by try/catch to handle errors
			try {
				s = new Scanner(new File("Stock.txt"));
				
				while (s.hasNext())
				{
				    list2.add(s.nextLine());
				    
				}
				for(i=0;i<list2.size();i=i+6) {
					
						String[] line = list2.get(i).split(",");
					
				}
			
				Collections.sort(list2);
				
				
				Stock.append(String.join("\n", list2));
				
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		 
		 
		/* This is the code that is implemented when the customer tries to add a book to cart 
		 * It helps the customer conduct transactions of the books they would like to purchase
		 */
			
		 if (e.getSource()==AddToCart) {
			// code that responds with error message if textfield is blank                                      
			 if(text.isEmpty()) {
				 JOptionPane.showMessageDialog(this, 
						  "Please enter a title in the text box!", "Failure", JOptionPane.ERROR_MESSAGE);
				 
			 }
			 else {
			 
			 // when customer clicks add to cart, the functionality of the 'filter by genre' button is disabled
			FilterGenre.setEnabled(false);
			
			// Surrounded by try/catch to handle errors
			try (BufferedWriter output = new BufferedWriter(new FileWriter("ActivityLog.txt", true))){
				s = new Scanner(new File("Stock.txt"));
				
				while (s.hasNext())
				{
					// Each row of the textfile is added to an arraylist, this is because it becomes easier to split into an array later on
				    list2.add(s.nextLine());
				    
				}
				
				for(i=0;i<list2.size();i++) {
					// Used for loop to help with splitting all elements of an arraylist into an array
					String[] line = list2.get(i).split(",");
					
					// If conditional exists to check that the book entered actually exists, if it does, it gets added to cart
				
					if((BookType.getSelectedItem().equals(line[2].trim())) && (text.equals(line[3].trim()))) {
						
					
						Stock.append(Arrays.toString(line).replace("[" , " ").replace("]", " ")  + "\n");
						
						// this is the variable that adds all the prices of the books taken and returns the amount to be paid when the checkout button has been clicked
						result = result + Float.parseFloat(line[6].trim());
						
						// MultipleBooks is an arraylist where all the items from the JTextArea get added to handle operations if the same book is added more than once
						MultipleBooks.add(Stock.getText());
						
						// The conditional exists to conduct operations if the book added to cart has already been added before
						if(MultipleBooks.toString().contains(text)) {
							int BookQuan = quantity++;
							
							
							// This conditional exists to check if customer adds more books than the available amount in the stock, an error message occurs
							if(BookQuan> Integer.parseInt(line[7].trim())){
								System.out.println("Not enough books");

							  
								JOptionPane.showMessageDialog(this, 
										  "Not Enough Books, add appropriate number of books", "Failure", JOptionPane.ERROR_MESSAGE);
								quantity = 1;
								Stock.selectAll();
								Stock.replaceSelection("");
								result = 0;
								Log2= "";
								
							}
							// If the same book is added more than once, the quantity is incremented in the log
							Log2=  (line[1].toString() + ", " + line[6].toString() + ", " + String.valueOf(BookQuan) +", ");   
							
							   
						  }
						
						else {
							
							Log2= "\n" + Login.Log.toString() + (line[1].toString() + ", " + line[6].toString() + ", " +String.valueOf(quantity)+", ");
						
						}
						
						break;	
					}
				
				
				}
				
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 }
	}
		 
		 
		 /* This is the code that is implemented when the customer wants to cancel transaction
		 * It helps the customer cancel their transaction
		*/
		 if(e.getSource()==CancelCart) {
			 
			 //error message when the cart is already empty
			 if(Stock.getText().trim().length()== 0) {
					JOptionPane.showMessageDialog(this, 
							  "Empty cart, please add something to cart to cancel!", "Failure", JOptionPane.ERROR_MESSAGE);
					
				}
			 else {
			
			quantity = 0;
			// Surrounded by try/catch to handle errors
			
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to cancel?","Warning",dialogButton);
			if(dialogResult == JOptionPane.YES_OPTION){
			//try(BufferedWriter output = new BufferedWriter(new FileWriter("ActivityLog.txt", true))){
			
				
			    
			    DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		    	 Date dateobj = new Date();
		    	 Log2+="cancelled" +  ", , " + df.format(dateobj) + "\n";
		    	String LastLog = Log2.toString();
			  
		    	 FinalCancelLog Log = new FinalCancelLog(df.format(dateobj),LastLog);
		    	 Log.CancelLog();
		    	// this.setVisible(false);
			
			Stock.selectAll();
			Stock.replaceSelection("");
			result = 0;
			}
		}
		 }
		 
		 if(e.getSource()==BackBtn) {
				this.setVisible(false);
				//AdminWindow Previous = new AdminWindow();
				
			}
				
	}
}
