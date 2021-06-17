

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*; 
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

//Above are all the imports needed for this class
// Below is the definition of the class which alsp implements ActionListener 

public class  Login extends JFrame implements ActionListener {
	
	/*This is the landing page of the application. When the Main class runs, this is the class that runs
	 * The user has 4 options of users to select from. These are displayed in the form of a dropdown list.
	 * One option takes the user to the Admin Window
	 * and the other 3 options takes the user to the Customer Window
	 */
		
			//Below are the initialized variables
			protected static String Log; 
			protected JComboBox log;
			protected JLabel log2;
			
			
			//This class handles the deeper specification of the initialised variables and formation of window
			public void LoginOperation(){
					
				 	String [] validusers = {"user1", "user2", "user3", "user4"};
				 	log = new JComboBox(validusers);
				 	
				 	ImageIcon Image = new ImageIcon("aaron-burden-AvqpdLRjABs-unsplash.jpg");
				 	log2 = new JLabel("Please choose any of the users to proceed:", Image, JLabel.RIGHT);
				 	log2.setFont(new Font("Verdana", Font.BOLD, 18));
				 	
				 	// ActionListener being added when any of the values from the JComboBox selected
				 	log.addActionListener(this);
				 	
				 	// Specifications of the layout and design of the window
				 	this.add(log2);
					this.add(log);
				   // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					this.setLayout(new FlowLayout());
					this.pack();
					this.setVisible(true);
					this.getContentPane().setBackground(new Color(0,255,255));
					
					
					
					
					}

			
		
			/*
			 * Below is the ActionListener that gets implemented when an option is selected from the dropdown list
			 */
			 
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					/*
					 * The content of the textfile is taken with the help of a scanner
					 * and each row is split into separate arrays
					 */
				
				Scanner s = new Scanner(new File("UserAccounts.txt"));
				
				// TODO Auto-generated catch block

				ArrayList<String> list = new ArrayList<String>();
						while (s.hasNext())
						{
						    list.add(s.nextLine());
						}
						
						String[] line = list.get(0).split(","); 
						String[] line1 = list.get(1).split(",");
						String[] line2 = list.get(2).split(",");
						String[] line3 = list.get(3).split(",");

				
						s.close();
						
						/*this is the functionality that takes place when an option is selected from the dropdown list
						 * the user that has been chosen, takes you to another window and the information for that option
						 * will be stored in an array so that it can be used later on when logging into text file
						 * Error handling used by surrounding with try/catch
						 * 
						 */
						if(e.getSource()==log) {
							
							
							if (log.getSelectedItem().equals(line[1].trim())) {
								JOptionPane.showMessageDialog(null, "You have successfully logged in as admin!");

								
								AdminWindow wow = new AdminWindow();
								this.setVisible(false);
								
								
							}
							
							
							else if(log.getSelectedItem().equals(line1[1].trim())) {
								JOptionPane.showMessageDialog(null, "You have successfully logged in as customer!");
								
								CustomerWindow newW = new CustomerWindow();
								this.setVisible(false);
							
								try(BufferedWriter output = new BufferedWriter(new FileWriter("ActivityLog.txt", true))){
									
								    Log = line1[0].toString()+ "," + line1[4].toString() + ",";
								
								
									}catch (IOException e1) {
								        System.out.println("Exception Occurred:");
								        e1.printStackTrace();
								}
						
							}
								
							
							else if(log.getSelectedItem().equals(line2[1].trim())) {
								JOptionPane.showMessageDialog(null, "You have successfully logged in as customer!");
								
								CustomerWindow newW = new CustomerWindow();
								this.setVisible(false);
							
								try(BufferedWriter output = new BufferedWriter(new FileWriter("ActivityLog.txt", true))){
									
								    Log = line2[0].toString()+ "," + line2[4].toString() + ",";
								
									
									}catch (IOException e1) {
								        System.out.println("Exception Occurred:");
								        e1.printStackTrace();
								}
						
							}
							else if (log.getSelectedItem().equals(line3[1].trim())) {
								JOptionPane.showMessageDialog(null, "You have successfully logged in as customer!");
								
								CustomerWindow newW = new CustomerWindow();
								this.setVisible(false);
								
								try(BufferedWriter output = new BufferedWriter(new FileWriter("ActivityLog.txt", true))){
									
								    Log = line3[0].toString()+ "," + line3[4].toString() + ",";
									
								
									}catch (IOException e1) {
								        System.out.println("Exception Occurred:");
								        e1.printStackTrace();
								}
							}
							
							
						}	
						
							
				 
				}catch (FileNotFoundException e1){
					 System.out.println("Wrong");
						
				}
				}
}




			

				
				
			 
				
		

				

