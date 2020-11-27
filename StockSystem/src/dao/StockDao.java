package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Stock;



public class StockDao {
private Connection connection;
	
	public StockDao() throws SQLException{
		this.connection = ConnectionDatabase.getConnection();
	}
	
	public void readProducts(Stock stock) throws SQLException{
		String sql = "SELECT ";
		PreparedStatement stmt = connection.prepareStatement(sql);
	}
	
	public void createProducts(Stock stock) throws SQLException{
		String sql = "INSERT INTO Stock(product, quantityAvalible) values (?,?,)";
		PreparedStatement stmt = connection.prepareStatement(sql);
	}
	
	public void alterProducts(Stock stock) throws SQLException{
		String sql = "ALTER";
		PreparedStatement stmt = connection.prepareStatement(sql);
	}
	
	public void removeProducts(Stock stock) throws SQLException{
		String sql = "DELETE";
		PreparedStatement stmt = connection.prepareStatement(sql);
	}
}
