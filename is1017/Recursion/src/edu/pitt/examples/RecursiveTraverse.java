package edu.pitt.examples;
import java.io.File;


public class RecursiveTraverse {

	
	public static void main(String[] args) {
		String path = "/Users/dmitriyb/Desktop/CODE/";
		traverse(new File(path));

	}
	
	private static void traverse(File dir){
		/* Check if the node is a file or a directory.  If it is a directory, look inside
		 * for files and sub-directories
		 */
	    if (dir.isDirectory()) {
	        String[] children = dir.list(); // get a list of all items (nodes) inside a directory
	        for (int i = 0; children != null && i < children.length; i++) {
	            traverse(new File(dir, children[i]));
	        }
	    }
	    if (dir.isFile()) {
	    		System.out.println(dir.getAbsolutePath());//change it if needed
	    }
	}

}
