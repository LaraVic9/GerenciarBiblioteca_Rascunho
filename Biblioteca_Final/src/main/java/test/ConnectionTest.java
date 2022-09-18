package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionFactory;

public class ConnectionTest {

	public static void main(String[] args) {
		
		Connection conn = ConnectionFactory.getConnection();
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Leitor");
			ResultSet Leitor = stmt.executeQuery();
			
			while(Leitor.next()) {
				Integer id = Leitor.getInt("id_leitor");
				String nome = Leitor.getString("nome");
				
				System.out.println(id + ": " + nome);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
