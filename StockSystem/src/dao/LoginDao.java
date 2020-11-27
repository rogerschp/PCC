package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.User;

public class LoginDao {
	private Connection connection;
	
	public LoginDao() throws SQLException{
		this.connection = ConnectionDatabase.getConnection();
	}
	public void insertCredentials(User user) throws SQLException{
		String sql = "insert into login(email, senha) values (?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setString(1,user.getEmail());
		stmt.setString(1,user.getPasswd());
		
		stmt.execute();
		stmt.close();
	}
	
	
}
