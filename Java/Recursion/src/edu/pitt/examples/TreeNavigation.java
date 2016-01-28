package edu.pitt.examples;

import java.sql.ResultSet;
import java.sql.SQLException;

import edu.pitt.utilities.DbUtilities;

public class TreeNavigation {
	public static void main(String[] args){
		getChildren(1);
	}
	
	public static void getChildren(int startNodeID){
		DbUtilities db = new DbUtilities();
		String sql = "SELECT * FROM nodetree WHERE parentNodeID = " + startNodeID + ";";
		try {
			ResultSet rs = db.getResultSet(sql);
			while(rs.next()){
				int nextParentNodeID = rs.getInt("childNodeID");
				System.out.println(nextParentNodeID);
				getChildren(nextParentNodeID);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
