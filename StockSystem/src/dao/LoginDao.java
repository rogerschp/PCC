package dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Login;

public class LoginDao {
	private Login login = new Login();
	private ResultSet resultLogin;
	
	
	public Connection connectDatabase() throws ClassNotFoundException, SQLException {
		Connection connect = ConnectionDatabase.initDatabase();
		return connect;
	}
	
	public void validationLoginDao(Connection connect, 
								HttpServletRequest request, 
								HttpServletResponse response) throws SQLException, IOException {
		
		login.setEmail(request.getParameter("email"));
		login.setSenha(request.getParameter("senha"));
		
		PrintWriter out = response.getWriter();
    	// Create a SQL query to insert data into demo table 
        // demo table consists of two columns, so two '?' is used 
		try {
			String sqlQuery = "SELECT * FROM login";
			PreparedStatement st = connect.prepareStatement(sqlQuery);
			resultLogin = st.executeQuery();
			
			while(resultLogin.next()) {
				String email = resultLogin.getString(1);
				String senha = resultLogin.getString(2);
				
				
				if (email!= login.getEmail() || senha != login.getSenha()) { 
//			        out.println("<html><body><b>Seu email ou senha estão incorretos."
//			                    + "</b></body></html>");
					request.getRequestDispatcher("WEB-INF/views/produtos.jsp")
																	.forward(((ServletRequest) request), 
																					((ServletResponse) response));
				} else {
			        out.println("<html><body><b>Sucesso ao fazer login."
			                    + "</b></body></html>");
				}
			}
			resultLogin.close();
			st.close();
			connect.close(); 
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
}
