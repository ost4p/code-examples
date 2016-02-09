package edu.pitt.examples;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class FibonacciSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("How many numbers in the sequence would you like to display: ");
		int sequenceLength = Integer.parseInt(input);
		
		long prevVal = 0;
		long nextVal = 1;
		System.out.print(prevVal + " ");
		System.out.print(nextVal + " ");
		for(int i = 0; i < sequenceLength; i++){
			long tempVal = nextVal;
			nextVal = prevVal + nextVal;
			prevVal = tempVal;
			System.out.print(nextVal + " ");
		}

	}

}
