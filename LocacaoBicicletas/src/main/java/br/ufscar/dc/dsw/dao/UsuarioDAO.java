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
		String sql = "INSERT INTO Usuario (papel, senha, login) VALUES (?, ?, ?)";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			;
			statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getPapel());
			statement.setString(2, usuario.getSenha());
			statement.setNString(3, usuario.getLogin());
			statement.executeUpdate();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Usuario> getAll() {
		List<Usuario> listaUsuarios = new ArrayList<>();
		String sql = "SELECT * from Usuario u";
		try {
			Connection conn = this.getConnection();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				long id = resultSet.getLong("id");
				String papel = resultSet.getString("papel");
				String senha = resultSet.getString("senha");
				String login = resultSet.getString("login");
				Usuario usuario = new Usuario(id, papel, senha, login);
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
		String sql = "DELETE FROM Usuario where id = ?";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, usuario.getId());
			statement.executeUpdate();
			statement.close();
			conn.close();
		} catch (SQLException e) {
		}
	}

	public void update(Usuario usuario) {
		String sql = "UPDATE Usuario SET papel = ?, senha = ?, login = ? WHERE id = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getPapel());
			statement.setString(2, usuario.getSenha());
			statement.setString(3, usuario.getLogin());
			statement.executeUpdate();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Usuario getbyID(Long id) {
		Usuario usuario = null;
		String sql = "SELECT * from Usuario WHERE id = ?";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String papel = resultSet.getString("papel");
				String senha = resultSet.getString("senha");
				String login = resultSet.getString("login");
				usuario = new Usuario(id, papel, senha, login);
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
		String sql = "SELECT * from Usuario WHERE login = ?";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, login);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String papel = resultSet.getString("papel");
				String senha = resultSet.getString("senha");
				usuario = new Usuario(id, papel, senha, login);
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