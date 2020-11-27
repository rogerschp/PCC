/*
Roger Schmidt de Paula RGM: 11191102577
*/

package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
       
    
     public static Connection getConexao() throws SQLException, ClassNotFoundException{
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/umc_aulas", "postgres", "root");
        return con;
    }
    
}
