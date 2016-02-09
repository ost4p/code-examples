package edu.pitt.guiexamples;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * This class shows how to deal with JTextfields and JTextArea  
 * @author Julio Guerra
 *
 */

public class ButtonExampleAction {
	private JFrame frmMainWindow;
	private JButton btnPushMe;
	private JLabel lblMessage;
	
	private int pushes;
	
	public ButtonExampleAction(){
		frmMainWindow = new JFrame("Button Example");
		frmMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMainWindow.setResizable(false);
        frmMainWindow.setBounds(200,200,350,100);
        frmMainWindow.setLayout(null);
        
        btnPushMe = new JButton("Push me");
        btnPushMe.setBounds(15,25,120,30);
        
        pushes = 0;
        
        // a listener is created and added to the button
        // This is a shortcut for creating another class for the listener
        // and instantiated the new listener class
        btnPushMe.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		// the variable pushes is private, but this ActionListener is an inner class
        		// and has access to everything in class ButtonExampleAction
                if (pushes == 0) JOptionPane.showMessageDialog(null, "click!");
                else if(pushes < 4) JOptionPane.showMessageDialog(null, "CLICK!");
                else {
                	JOptionPane.showMessageDialog(null, "You pushed too much. Good bye :(");
                	System.exit(0); // this ends a program in Java
                }
                pushes++;
            }
        });

        lblMessage = new JLabel("<- push this button");
        lblMessage.setBounds(150,25,200,30);        
        
        frmMainWindow.add(btnPushMe);
        frmMainWindow.add(lblMessage);

        frmMainWindow.setVisible(true);
	}
	
	public static void main(String[] args) {
		ButtonExampleAction be = new ButtonExampleAction();
	}

}
