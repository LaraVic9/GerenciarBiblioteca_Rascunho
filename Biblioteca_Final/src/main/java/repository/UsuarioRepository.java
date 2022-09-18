package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import app.Leitor;
import connection.ConnectionFactory;

public class UsuarioRepository {

	private Connection connection;
	
	public UsuarioRepository() {
		connection = ConnectionFactory.getConnection();
	}
	
	public Leitor insert(Leitor leitor) {
		
		PreparedStatement statement = null;
		
		try {
			
			String sql = "INSERT INTO Leitor (nome, sobrenome) VALUES(?, ?)";
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, leitor.getNome());
			statement.setString(2, leitor.getSobrenome());
			
			int rowAffected = statement.executeUpdate();
			
			if(rowAffected > 0) {
				ResultSet ids = statement.getGeneratedKeys();
				
				while (ids.next()) {
					leitor.setId(ids.getInt(1));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return leitor;
	}
	
}
