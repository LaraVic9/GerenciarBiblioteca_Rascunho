package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static Connection conn = null;
	
	public static Connection getConnection() {
		
		if(conn == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ifpr_store", "lara", "LaraVictoria123_@;");
				
			} catch (SQLException | ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return conn;
		
	}
	
}
