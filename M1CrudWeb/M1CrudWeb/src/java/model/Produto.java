package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.List;
import util.Conexao;


public class Produto {

    private int id;
    private String descricao;
    private double preco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void cadastrar() throws ClassNotFoundException, SQLException {

        Connection con = Conexao.getConexao();

        PreparedStatement comando = con.prepareStatement("insert into produto (nome, preco) values (?,?)");
        comando.setString(1, this.getDescricao());
        comando.setDouble(2, this.getPreco());
        comando.execute();
        con.close();

    }
    
    public Produto consultarPorID(int id) throws ClassNotFoundException, SQLException{
        
        Connection con = Conexao.getConexao();
                
        PreparedStatement comando = con.prepareStatement("Select id, nome, preco from produto where id=?");
        comando.setInt(1, id);
        
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

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/umc_aulas", "postgres", "root");

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
