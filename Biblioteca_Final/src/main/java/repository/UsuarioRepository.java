package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.Leitor;
import connection.ConnectionFactory;

public class UsuarioRepository {

	private Connection connection;
	
	public UsuarioRepository() {
		connection = ConnectionFactory.getConnection();
	}
	
	public void insertLeitor(Leitor leitor) {
		
		PreparedStatement prepareStatement = null;
		
		try {
			
			String sql = "INSERT INTO Leitor (nome, sobrenome) VALUES(?, ?)";
			prepareStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			prepareStatement.setString(1, leitor.getNome());
			prepareStatement.setString(2, leitor.getSobrenome());
			
			int rowAffected = prepareStatement.executeUpdate();
			
			if(rowAffected > 0) {
				ResultSet ids = prepareStatement.getGeneratedKeys();
				
				while (ids.next()) {
					leitor.setId(ids.getInt(1));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteLeitor(int id) {
		try {
			
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM LEITOR WHERE id_leitor=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateLeitor(Leitor leitor) {
		try {
			
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE Leitor SET nome=?, sobrenome=?" +
							"WHERE id_leitor=?");
			
			preparedStatement.setString(1, leitor.getNome());
			preparedStatement.setString(2, leitor.getSobrenome());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Leitor> getAllLeitor(){
		List<Leitor> listaDeLeitores = new ArrayList<Leitor>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Leitor");
			while (rs.next()) {
				
				Leitor leitor = new Leitor();
				leitor.setId(rs.getInt("id_leitor"));
				leitor.setNome(rs.getString("nome"));
				leitor.setNome(rs.getString("sobrenome"));
				listaDeLeitores.add(leitor);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaDeLeitores;
		
		
	}
	
	public Leitor getLeitorById(int leitorId) {
		Leitor leitor = new Leitor();
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Leitor WHERE id_leitor=?");
			preparedStatement.setInt(1, leitorId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				
				leitor.setId(rs.getInt("leitorId"));
				leitor.setNome(rs.getString("nome"));
				leitor.setNome(rs.getString("sobrenome"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return leitor;
		
	}
	
}
