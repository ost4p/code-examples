package edu.pitt.examples;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FibSequenceRecursive {


	public static long fib(int n) {
		if (n <= 1)
			return n;
		else
			return fib(n - 1) + fib(n - 2);
	}

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("How many numbers in the sequence would you like to display: ");
		
		int N = Integer.parseInt(input);
		for (int i = 0; i < N; i++)
			System.out.print(fib(i) + " ");
	}

}
