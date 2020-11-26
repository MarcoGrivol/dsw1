package br.ufscar.dc.dsw.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.ufscar.dc.dsw.domain.Usuario;

public class UsuarioDAO extends GenericDAO {

	public void insert(Usuario usuario) {
		String sql = "INSERT INTO Usuario (cpf, data_nascimento, email, login, nome, senha, sexo, telefone, papel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			;
			statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getCPF());
			statement.setString(2, usuario.getDataNascimento());
			statement.setString(3, usuario.getEmail());
			statement.setString(4, usuario.getLogin());
			statement.setString(5, usuario.getNome());
			statement.setString(6, usuario.getSenha());
			statement.setString(7, usuario.getSexo());
			statement.setString(8, usuario.getTelefone());
			statement.setString(9,usuario.getPapel());
			statement.executeUpdate();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Usuario> getAll() {
		List<Usuario> listaUsuarios = new ArrayList<>();
		String sql = "SELECT * from Usuario WHERE papel = ?";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			String papel = "USER";
			statement.setString(1, papel);
			ResultSet resultSet = statement.executeQuery();
			// Statement statement = conn.createStatement();
			// ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String CPF = resultSet.getString("cpf");
				String data_nascimento = resultSet.getString("data_nascimento");
				String email = resultSet.getString("email");
				String login = resultSet.getString("login");
				String nome = resultSet.getString("nome");
				String senha = resultSet.getString("senha");
				String sexo = resultSet.getString("sexo");
				String telefone = resultSet.getString("telefone");
				Usuario usuario = new Usuario(CPF, data_nascimento, email, login, nome, senha, sexo, telefone, papel);
				listaUsuarios.add(usuario);
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaUsuarios;
	}

	public void delete(Usuario usuario) {
		String sql = "DELETE FROM Usuario where cpf = ?";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getCPF());
			statement.executeUpdate();
			statement.close();
			conn.close();
		} catch (SQLException e) {
		}
	}

	public void update(Usuario usuario) {
		String sql = "UPDATE usuario SET data_nascimento = ?, email = ?, login = ?, nome = ?, senha = ?, sexo = ?, telefone = ?, papel = ? WHERE cpf = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getDataNascimento());
			statement.setString(2, usuario.getEmail());
			statement.setString(3, usuario.getLogin());
			statement.setString(4, usuario.getNome());
			statement.setString(5, usuario.getSenha());
			statement.setString(6, usuario.getSexo());
			statement.setString(7, usuario.getTelefone());
			statement.setString(8, usuario.getPapel());
			statement.executeUpdate();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Usuario getbyID(String CPF) {
		Usuario usuario = null;
		String sql = "SELECT * from Usuario WHERE cpf = ?";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, CPF);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String data_nascimento = resultSet.getString("data_nascimento");
				String email = resultSet.getString("email");
				String login = resultSet.getString("login");
				String nome = resultSet.getString("nome");
				String senha = resultSet.getString("senha");
				String sexo = resultSet.getString("sexo");
				String telefone = resultSet.getString("telefone");
				String papel = resultSet.getString("papel");
				usuario = new Usuario(CPF, data_nascimento, email, login, nome, senha, sexo, telefone, papel);
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return usuario;
	}

	public Usuario getbyLogin(String login) {
		Usuario usuario = null;
		String sql = "SELECT * from usuario WHERE login = ?";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, login);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String CPF = resultSet.getString("cpf");
				String data_nascimento = resultSet.getString("data_nascimento");
				String email = resultSet.getString("email");
				String nome = resultSet.getString("nome");
				String senha = resultSet.getString("senha");
				String sexo = resultSet.getString("sexo");
				String telefone = resultSet.getString("telefone");
				String papel = resultSet.getString("papel");
				usuario = new Usuario(CPF, data_nascimento, email, login, nome, senha, sexo, telefone, papel);
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return usuario;
	}
}