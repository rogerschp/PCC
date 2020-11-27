package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Produto;
import util.Conexao;

/**
 *
 * @author User
 */
public class ProdutoDAO {
    
    public void alterar(Produto p) throws ClassNotFoundException, SQLException{
        
        Connection con = Conexao.getConexao();
        
        PreparedStatement comando = con.prepareStatement("update produto set nome = ?, preco = ? where id = ?");
        comando.setString(1, p.getDescricao());
        comando.setDouble(2,p.getPreco());
        comando.setInt(3, p.getId());
        comando.execute();
        con.close();
    }
    
    public void deletar(Produto p) throws ClassNotFoundException, SQLException{
        
        Connection con = Conexao.getConexao();
        
        PreparedStatement comando = con.prepareStatement("delete from produto where id = ?");
        comando.setInt(1, p.getId());
        comando.execute();
        con.close();
        
    }
    
    public void cadastrar(Produto p) throws ClassNotFoundException, SQLException {

        Connection con = Conexao.getConexao();

        PreparedStatement comando = con.prepareStatement("insert into produto (nome, preco) values (?,?)");
        comando.setString(1, p.getDescricao());
        comando.setDouble(2, p.getPreco());
        comando.execute();
        con.close();

    }
    
    public Produto consultarPorID(Produto prod) throws ClassNotFoundException, SQLException{
        
        Connection con = Conexao.getConexao();
                
        PreparedStatement comando = con.prepareStatement("Select id, nome, preco from produto where id=?");
        comando.setInt(1, prod.getId());
        
        ResultSet resultado = comando.executeQuery();
        Produto p = new Produto();
        if(resultado.next()){
            p.setId(resultado.getInt("id"));
            p.setDescricao(resultado.getString("nome"));
            p.setPreco(resultado.getDouble("preco"));
        }
        con.close();
        
        
        return p;
        
    }
    
    public List<Produto> consultarTodos() throws ClassNotFoundException, SQLException {

        Connection con = Conexao.getConexao();

        PreparedStatement comando = con.prepareStatement("select id, nome, preco from produto");
        ResultSet resultado = comando.executeQuery();

        List<Produto> todosProdutos = new ArrayList<Produto>();

        while (resultado.next()) {

            Produto p = new Produto();
            p.setId(resultado.getInt("id"));
            p.setDescricao(resultado.getString("nome"));
            p.setPreco(resultado.getDouble("preco"));
            todosProdutos.add(p);

        }
        con.close();
        return todosProdutos;

    }

    
    
}
