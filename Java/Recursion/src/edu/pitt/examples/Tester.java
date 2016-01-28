package edu.pitt.examples;

public class Tester {
	public static void main(String[] args){
		MergeSort ms = new MergeSort();

		int[] arr = {1,45,54,23,65,473,4342,23,2,7};
		
		int[] result = ms.sort(arr);
		for(int i = 0; i < result.length; i++){
			System.out.print(result[i] + " ");
		}
	}
}
