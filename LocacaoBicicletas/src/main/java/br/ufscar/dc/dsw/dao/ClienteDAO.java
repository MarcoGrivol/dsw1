/*package br.ufscar.dc.dsw.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.ufscar.dc.dsw.domain.Cliente;

public class ClienteDAO extends GenericDAO {

	public void insert(Cliente cliente) {
		String sql = "INSERT INTO Cliente (cpf, data_nascimento, email, login, nome, senha, sexo, telefone, papel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			;
			statement = conn.prepareStatement(sql);
			statement.setString(1, cliente.getCPF());
			statement.setString(2, cliente.getDataNascimento());
			statement.setString(3, cliente.getEmail());
			statement.setString(4, cliente.getLogin());
			statement.setString(5, cliente.getNome());
			statement.setString(6, cliente.getSenha());
			statement.setString(7, cliente.getSexo());
			statement.setString(8, cliente.getTelefone());
			statement.setString(9,cliente.getPapel());
			statement.executeUpdate();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Cliente> getAll() {
		List<Cliente> listaClientes = new ArrayList<>();
		String sql = "SELECT * from CLiente u";
		try {
			Connection conn = this.getConnection();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				long id = resultSet.getLong("id");
				String CPF = resultSet.getString("cpf");
				String data_nascimento = resultSet.getString("data_nascimento");
				String email = resultSet.getString("email");
				String login = resultSet.getString("login");
				String nome = resultSet.getString("nome");
				String senha = resultSet.getString("senha");
				String sexo = resultSet.getString("sexo");
				String telefone = resultSet.getString("telefone");
				String papel = resultSet.getString("papel");
				Cliente cliente = new Cliente(id, CPF, data_nascimento, email, login, nome, senha, sexo, telefone, papel);
				listaClientes.add(cliente);
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaClientes;
	}

	public void delete(Cliente cliente) {
		String sql = "DELETE FROM Cliente where id = ?";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, cliente.getId());
			statement.executeUpdate();
			statement.close();
			conn.close();
		} catch (SQLException e) {
		}
	}

	public void update(Cliente cliente) {
		String sql = "UPDATE Cliente SET cpf = ?, data_nascimento = ?, email = ?, login = ?, nome = ?, senha = ?, sexo = ?, telefone = ?, papel = ? WHERE id = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, cliente.getCPF());
			statement.setString(2, cliente.getDataNascimento());
			statement.setString(3, cliente.getEmail());
			statement.setString(4, cliente.getLogin());
			statement.setString(5, cliente.getNome());
			statement.setString(6, cliente.getSenha());
			statement.setString(7, cliente.getSexo());
			statement.setString(8, cliente.getTelefone());
			statement.setString(9, cliente.getPapel());
			statement.executeUpdate();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Cliente getbyID(Long id) {
		Cliente cliente = null;
		String sql = "SELECT * from Cliente WHERE id = ?";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String CPF = resultSet.getString("cpf");
				String data_nascimento = resultSet.getString("data_nascimento");
				String email = resultSet.getString("email");
				String login = resultSet.getString("login");
				String nome = resultSet.getString("nome");
				String senha = resultSet.getString("senha");
				String sexo = resultSet.getString("sexo");
				String telefone = resultSet.getString("telefone");
				String papel = resultSet.getString("papel");
				cliente = new Cliente(id, CPF, data_nascimento, email, login, nome, senha, sexo, telefone, papel);
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return cliente;
	}

	public Cliente getbyLogin(String login) {
		Cliente cliente = null;
		String sql = "SELECT * from Cliente WHERE login = ?";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, login);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				long id = resultSet.getLong("id");
				String CPF = resultSet.getString("cpf");
				String data_nascimento = resultSet.getString("data_nascimento");
				String email = resultSet.getString("email");
				String nome = resultSet.getString("nome");
				String senha = resultSet.getString("senha");
				String sexo = resultSet.getString("sexo");
				String telefone = resultSet.getString("telefone");
				String papel = resultSet.getString("papel");
				cliente = new Cliente(id, CPF, data_nascimento, email, login, nome, senha, sexo, telefone, papel);
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return cliente;
	}
}*/