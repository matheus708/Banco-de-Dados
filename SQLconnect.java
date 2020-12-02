import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;


public class SQLconnect {
	public static void main(String[] args) {
	
	String server = "LAPTOP-6RTEV8HD\\SQLEXPRESS01";
    int port = 52202 ;
    String user = "sa";
    String pass = "496758123q";
    String database = "Escola";
    String jdbcurl = "jdbc:sqlserver://"+server+":"+port+";user="+user+";password="+pass+";databasename="+database+"";
    Connection con = null; 
    
   		

    try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    } catch (ClassNotFoundException e1) {
        e1.printStackTrace();
    }   
        
    try {
            con = DriverManager.getConnection(jdbcurl);
    }
	
    
    
    catch (SQLException e) {
    		e.printStackTrace();
    		
    		
    }
    }
}

