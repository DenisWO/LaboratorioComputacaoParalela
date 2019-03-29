package model.dao;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.MyConnection;
import model.bean.Produto;

public class ProdutoDAO {
	private String tabela = "Produtos";
    private Connection connection;
    private String query;
    
    public boolean inserirProduto(Produto produto){
        connection = MyConnection.getConexaoMysql();
        query = "INSERT INTO " + tabela + " (NOME, QUANTIDADE, VALOR) VALUES (?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1,produto.getNome());
            stmt.setFloat(2,produto.getQuantidade());
            stmt.setFloat(3,produto.getValor());

            stmt.execute();
            stmt.close();
            return TRUE;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return FALSE;
    }
    
    public boolean atualizarProduto( Produto produto){
        connection = MyConnection.getConexaoMysql();
        query = "UPDATE " + tabela + " SET NOME = ?, QUANTIDADE = ?, VALOR = ?, WHERE ID = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, produto.getNome());
            stmt.setFloat(2, produto.getQuantidade());
            stmt.setFloat(3, produto.getValor());
            stmt.setInt(5, produto.getId());

            stmt.executeUpdate();
            return TRUE;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FALSE;
    }
    
    public boolean deletarProduto( Produto produto){
        connection = MyConnection.getConexaoMysql();
        query = "DELETE FROM " + tabela + " WHERE ID = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, produto.getId());

            stmt.executeUpdate();
            return TRUE;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return FALSE;
    }
    
    public boolean deletarTodosProdutos(){
        connection = MyConnection.getConexaoMysql();
        query = "DELETE FROM " + tabela;

        try {
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.executeUpdate();
            return TRUE;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return FALSE;
    }
    
    public ArrayList<Produto> selecionaTodosRegistros(){
        ArrayList<Produto> produtos = new ArrayList<>();
        connection = MyConnection.getConexaoMysql();
        query = "SELECT ID, NOME, QUANTIDADE, VALOR FROM " + tabela;
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            System.out.println(query);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
               produtos.add( new Produto(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getFloat(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produtos;
    }
    
    public Produto selecionaPeloId(int id){
        Produto produto = new Produto();
        connection = MyConnection.getConexaoMysql();
        query = "SELECT ID, NOME, QUANTIDADE, VALOR FROM " + tabela + " WHERE ID = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                produto.setId(rs.getInt(1));
                produto.setNome(rs.getString(2));
                produto.setQuantidade(rs.getFloat(3));
                produto.setValor( rs.getFloat(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produto;
    }
    
    public boolean zerarAutoIncremento(){
        this.deletarTodosProdutos();
        connection = MyConnection.getConexaoMysql();
        query = "ALTER TABLE " + tabela + " AUTO_INCREMENT = 1";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}