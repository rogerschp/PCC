package dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;

public class ProductDao {
	private Product product = new Product();
	private String sqlInsert = "INSERT INTO product (product_name, product_quantity) VALUES (?, ?)";
	private String sqlSelect = "SELECT * FROM product";
	private String sqlUpdate = "UPDATE product SET product_name, product_quantity WHERE product_name = (?) AND product_quantity = (?)";
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
	
	public void readProduct(Connection connect, HttpServletRequest request, HttpServletResponse response) {
		
		
		try {
			PrintWriter out = response.getWriter();
			String sqlQuery = "SELECT * FROM login";
			PreparedStatement st = connect.prepareStatement(sqlSelect);
			resultProduct = st.executeQuery();
			
			while(resultProduct.next()) {
				String name = resultProduct.getString(1);
				String amount = resultProduct.getString(2);
				
				out.println("<html>"
						+ "<body><b>Sucesso ao buscar produtos."+ "${"+name+"}" + "${"+amount+"}"
	                    + "</b></body></html>");
			}
			resultProduct.close();
			st.close();
			connect.close(); 
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
	public void updateProduct(Connection connect, HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	public void deleteProduct(Connection connect, HttpServletRequest request, HttpServletResponse response) {
	
	}

}
