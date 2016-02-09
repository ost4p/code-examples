package edu.pitt.guiexamples;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This class shows how to add a button and a label to a window
 * with no layout manager (null). The class is instantiated in the main
 * method at the end.   
 * 
 * @author Julio Guerra
 *
 */
public class ButtonExample {
	// there are three elements: a window, a button and a label (text)
	private JFrame frmMainWindow;
	private JButton btnPushMe;
	private JLabel lblMessage;
	
	// the constructor makes most of the work
	public ButtonExample(){
		// defines the window (JFrame)
		frmMainWindow = new JFrame("Button Example"); // the contructor allows to specify a title for the window
		frmMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // makes the program to end when the window is closed
		frmMainWindow.setResizable(false); // the window can not be resizable
		frmMainWindow.setBounds(200,200,350,100); // start in the position 200,200 o the screen and it is 350 pixels wide and 100 pixels tall
		frmMainWindow.setLayout(null); // no layout manager
        
        // defines the button 
		btnPushMe = new JButton("Push me"); // It says "Push me"
		btnPushMe.setBounds(15,25,120,30); // it is located in the position 15,25 (x,y of the window), and si 120 pixels wide and 30 pixels heigh. 
        
        // defines the label
		lblMessage = new JLabel("<- push this button");
		lblMessage.setBounds(150,25,200,30);
        
        // adds the button and the label to the window
        frmMainWindow.add(btnPushMe);
        frmMainWindow.add(lblMessage);
        
        // display the window
        frmMainWindow.setVisible(true);
	}
	
	public static void main(String[] args) {
		ButtonExample be = new ButtonExample();
	}

}
