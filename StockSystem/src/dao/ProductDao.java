package dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Product;

public class ProductDao {
	private Product product = new Product();
	private String sqlInsert = "INSERT INTO product (product_name, product_quantity) VALUES (?, ?)";
	private String sqlSelect = "SELECT product_name, product_quantity FROM product WHERE name =?";
	private String sqlSelectAll = "SELECT * FROM product";
	private String sqlUpdate = "UPDATE product SET product_name = ?, product_quantity = ? WHERE product_name = ?";
	private String sqlDelete = "DELETE ";
	private ResultSet resultProduct;
	
	public Connection connectionDatabase() throws ClassNotFoundException, SQLException {
		Connection connect = ConnectionDatabase.initDatabase();
		return connect;
	}
	
	public void insertProduct(Connection connect, HttpServletRequest request, 
								HttpServletResponse response) throws SQLException {	
		product.setName(request.getParameter("nameProduct"));
		product.setAmount(request.getParameter("amountProduct"));
		
		try {
			PreparedStatement st = connect.prepareStatement(sqlInsert);
			
			st.setString(1, product.getName());
			st.setInt(2, Integer.valueOf(product.getAmount()));
			
			st.executeUpdate();
			
			st.close();
			connect.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Product readProduct(Connection connect, HttpServletRequest request, HttpServletResponse response) throws IOException {
		Product product  = null;
		PrintWriter out = response.getWriter();
		int id = 0;
		String name = "";
		String amount = "";
		try {
			PreparedStatement st = connect.prepareStatement(sqlSelect);
			resultProduct = st.executeQuery();
			
			while(resultProduct.next()) {
//				id = resultProduct.getInt(1);
				name = resultProduct.getString(2);
				amount = resultProduct.getString(3);
				product = new Product(name, amount);
			}
			out.println("<html>"
					+ "<body><b>Sucesso ao buscar produto:" + "${"+name+"}"
	                + "${" + product + "}" + "</b></body></html>");
			resultProduct.close();
			st.close();
			connect.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	
	public List<Product> readAllProduct(Connection connect, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List<Product> arrayProducts = new ArrayList<>();
		PrintWriter out = response.getWriter();
		int id = 0;
		String name = "";
		String amount = "";
		
		try {
			PreparedStatement st = connect.prepareStatement(sqlSelectAll);
			resultProduct = st.executeQuery();
			
			while(resultProduct.next()) {
//				id = resultProduct.getInt(1);
				name = resultProduct.getString(2);
				amount = resultProduct.getString(3);
				arrayProducts.add(new Product(name, amount));
			}
			out.println("<html>"
					+ "<body><b>Sucesso ao buscar produtos."+ "${"+arrayProducts+"}"
	                + "</b></body></html>");
			resultProduct.close();
			st.close();
			connect.close(); 
        } catch (Exception e) {
        	e.printStackTrace();
        }
		
		return arrayProducts;
	}
	
	public void updateProduct(Connection connect, HttpServletRequest request, HttpServletResponse response) {
		String name = product.getName();
		product.setName(request.getParameter("nameProduct"));
		product.setAmount(request.getParameter("amountProduct"));
		
		try {
			PreparedStatement st = connect.prepareStatement(sqlUpdate);
//			st.setInt(1, product.getId());
			st.setString(1, product.getName());
			st.setInt(2, Integer.valueOf(product.getAmount()));
			st.setString(3, name);
			
			st.executeUpdate();
			
			st.close();
			connect.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteProduct(Connection connect, HttpServletRequest request, HttpServletResponse response) {
		product.setName(request.getParameter("nameProduct"));
			try {
				PreparedStatement st = connect.prepareStatement(sqlDelete);
				st.setString(1, product.getName());
				st.executeUpdate();
				st.close();
				connect.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	}

}
