/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package analyzer;

/**
 *
 * @author dbabichenko
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class dbUtilities {
    
    private Connection conn = null;
    private String hostName = "127.0.0.1";
    private String dbName = “test”;
    private String dbUserName = “test”;
    private String dbPassword = “yest”;

    public dbUtilities(){
        try{
            String mySqlConn = "jdbc:mysql://" + hostName + "/" + dbName + "?user=" + dbUserName + "&password=" + dbPassword;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(mySqlConn);
        }
        catch(Exception e){
            System.err.print(e.toString());
            System.err.println("Unable to connect to database");
        }
    }

    public void setHostName(String _hostName){
        hostName = _hostName;
    }

    public void setDbName(String _dbName){
        dbName = _dbName;
    }

    public void setDbUserCredentials(String _dbUserName, String _dbPassword){
        dbUserName = _dbUserName;
        dbPassword = _dbPassword;
    }
    

    public ResultSet getMySqlResultSet(String qry) throws SQLException{
        Statement cmd = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost/dictionary?user=testuser&password=testuser");
            cmd = conn.createStatement();
            rs = cmd.executeQuery(qry);
        }
        catch(Exception e){
            System.err.println("Unable to connect to database");
        }
        return rs;
    }


}
