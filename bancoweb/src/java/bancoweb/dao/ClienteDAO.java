/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancoweb.dao;

import bancoweb.model.Cliente;
import bancoweb.utils.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class ClienteDAO {

    Connection conexao;

    public List<Cliente> listarClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();

        conexao = DBConnection.getConnection();

        String sql = "SELECT * FROM clientes ORDER BY nome";
        PreparedStatement stmt;

        stmt = this.conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Cliente cliente = new Cliente(rs.getString("nome"), rs.getString("sexo").charAt(0),
                    rs.getString("email"), rs.getString("estado_civil"));
            cliente.setId(rs.getInt("codigo"));

            clientes.add(cliente);
        }
        rs.close();
        stmt.close();
        conexao.close();

        return clientes;
    }

    public int inserirCliente(Cliente cliente) {

        int status = 0;
        String sql = "INSERT INTO clientes (nome, sexo, email, `estado_civil`) VALUES (?, ?, ?, ?)";
        conexao = DBConnection.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = this.conexao.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, String.valueOf(cliente.getSexo()));
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getEstadoCivil());

            status = stmt.executeUpdate();

            stmt.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public int editarCliente(Cliente cliente) {
        int status = 0;
        String sql = "UPDATE clientes SET nome = ?,  sexo = ?,  email = ?, estado_civil = ? WHERE codigo = ?";

        conexao = DBConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, String.valueOf(cliente.getSexo()));
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getEstadoCivil());
            stmt.setInt(5, cliente.getId());

            status = stmt.executeUpdate();

            stmt.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public int excluirCliente(int id){
        int status = 0;
            String sql = "DELETE FROM clientes WHERE codigo = ?";
            
            conexao = DBConnection.getConnection();
            PreparedStatement stmt = null;
            try {
            stmt = conexao.prepareStatement(sql);
            
            stmt.setInt(1, id);
            status = stmt.executeUpdate();
            
            stmt.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            return status;
    }

    public Cliente buscarCliente(int id) {

        Cliente cliente = null;

        conexao = DBConnection.getConnection();

        String sql = "SELECT * FROM clientes WHERE codigo = ?";

        PreparedStatement stmt;

        try {
            stmt = this.conexao.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                cliente = new Cliente(rs.getString("nome"), rs.getString("sexo").charAt(0),
                        rs.getString("email"), rs.getString("estado_civil"));
                cliente.setId(rs.getInt("codigo"));

            }
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cliente;
    }
}
