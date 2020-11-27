package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Products;

public class ProdutoDao {
	private Connection connection;
	
	public ProdutoDao() throws SQLException{
		this.connection = ConnectionDatabase.getConnection();
	}
	public void readProducts(Products products) throws SQLException{
		String sql = "SELECT ";
		PreparedStatement stmt = connection.prepareStatement(sql);
	}
	
	public void createProducts(Products products) throws SQLException{
		String sql = "INSERT INTO Products(name, quantity) values (?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
	}
	
	public void alterProducts(Products products) throws SQLException{
		String sql = "ALTER";
		PreparedStatement stmt = connection.prepareStatement(sql);
	}
	
	public void removeProducts(Products products) throws SQLException{
		String sql = "DELETE";
		PreparedStatement stmt = connection.prepareStatement(sql);
	}
	
}
