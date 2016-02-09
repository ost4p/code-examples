package edu.pitt.guiexamples;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * This class shows how a combo box can manage objects and not just strings
 * @author Julio Guerra
 *
 */

public class ComboBoxExample2 {
	private JFrame frmMainWindow;
	private JComboBox cboOptions;
	private JLabel lblMessage;
	private Person[] people;
	public ComboBoxExample2(){
		
		frmMainWindow = new JFrame("Button Example");
		frmMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMainWindow.setResizable(false);
        frmMainWindow.setBounds(200,200,350,100);
        frmMainWindow.setLayout(null);
         
        
        lblMessage = new JLabel("");
        lblMessage.setBounds(20,35,330,35);
        lblMessage.setFont(new Font("Arial", 1, 14));
        
        // 
        people = new Person[4];
        people[0] = new Person("John");
        people[1] = new Employee("Anna");
        people[2] = new Employee("Julio");
        people[3] = new Person("Amanda");

		// The combobox is created using an array of Person. Each person can be 
        // and object of the class Person of an object of class Employee (Employee 
        // extends Person). The combobox allows us to add any type of objects to it
        // and it displays objects calling the method toString()
		cboOptions = new JComboBox(people);
	
		cboOptions.setBounds(15,10,150,25);
		cboOptions.setSelectedIndex(-1); // by default, none is selected
		
		
		cboOptions.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		// the event object (e) can access the component that generated the 
        		// event (you could eventually attach a listener to many different components).
        		JComboBox cb = (JComboBox)e.getSource();
        		
        		Person p = (Person)cb.getSelectedItem();
        		
        		lblMessage.setText(p.introduceMyself());
            }
        });
		 
		frmMainWindow.add(cboOptions);
		frmMainWindow.add(lblMessage);

		frmMainWindow.setVisible(true);
		
	}
	public static void main(String[] args) {
		ComboBoxExample2 cbe = new ComboBoxExample2();

	}

}
