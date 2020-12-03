package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao productDao = new ProductDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			
			if (request.getParameter("registerProduct") != null) {
				insertProduct(connectionDaatabase(), request, response);
			} else if (request.getParameter("readProduct") != null) {
				readProduct(connectionDaatabase(), request, response);
			} else if (request.getParameter("updateProduct") != null) {
				updateProduct(connectionDaatabase(), request, response);
			} else if (request.getParameter("deleteProduct") != null) {
				deleteProduct(connectionDaatabase(), request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private Connection connectionDaatabase() throws ClassNotFoundException, SQLException {
		return productDao.connectionDatabase();
	}
	
	private void insertProduct(Connection connect, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		productDao.insertProduct(connect, request, response);
	}
	
	private void readProduct(Connection connect, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		productDao.readProduct(connect, request, response);
	}
	
	private void updateProduct(Connection connect, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		productDao.updateProduct(connect, request, response);
	}
	
	private void deleteProduct(Connection connect, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		productDao.deleteProduct(connect, request, response);
	}

}
