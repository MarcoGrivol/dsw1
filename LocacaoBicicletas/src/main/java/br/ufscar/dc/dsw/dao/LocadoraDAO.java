package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.ufscar.dc.dsw.domain.Locadora;

public class LocadoraDAO extends GenericDAO {

	public void insert(Locadora locadora) {
		String sql = "INSERT INTO Locadora (cnpj, email, nome, senha,cidade,papel) VALUES (?, ?, ?, ?,?,?)";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			;
			statement = conn.prepareStatement(sql);
			statement.setString(1, locadora.getCnpj());
			statement.setString(2, locadora.getEmail());
			statement.setString(3, locadora.getNome());
			statement.setString(4, locadora.getSenha());
			statement.setString(5, locadora.getCidade());
			statement.setString(6, locadora.getPapel());

			statement.executeUpdate();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Locadora> getAll() {
		List<Locadora> listaLocadora = new ArrayList<>();
		String sql = "SELECT * from Locadora";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			// Statement statement = conn.createStatement();
			// ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String cnpj = resultSet.getString("cnpj");
				String email = resultSet.getString("email");
				String nome = resultSet.getString("nome");
				String senha = resultSet.getString("senha");
				String cidade = resultSet.getString("cidade");
				String papel = resultSet.getString("papel");
				Locadora locadora = new Locadora(cnpj, email, nome, senha, cidade, papel);
				listaLocadora.add(locadora);
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaLocadora;
	}

	public void delete(Locadora locadora) {
		String sql = "DELETE FROM Locadora where cnpj = ?";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, locadora.getCnpj());
			statement.executeUpdate();
			statement.close();
			conn.close();
		} catch (SQLException e) {
		}
	}

	public void update(Locadora locadora) {
		String sql = "UPDATE locadora SET email = ?, nome = ?, senha = ?, cidade = ? WHERE cnpj = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, locadora.getEmail());
			statement.setString(2, locadora.getNome());
			statement.setString(3, locadora.getSenha());
			statement.setString(4, locadora.getCidade());
			statement.setString(5, locadora.getCnpj());
			statement.executeUpdate();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Locadora getbyCnpj(String cnpj) {
		Locadora locadora = null;
		String sql = "SELECT * from Locadora WHERE cnpj = ?";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, cnpj);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String email = resultSet.getString("email");
				String nome = resultSet.getString("nome");
				String senha = resultSet.getString("senha");
				String cidade = resultSet.getString("cidade");
				String papel = resultSet.getString("papel");

				locadora = new Locadora(cnpj, email, nome, senha, cidade, papel);
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return locadora;
	}

	public Locadora getbyEmail(String email) {
		Locadora locadora = null;
		String sql = "SELECT * from Locadora WHERE email = ?";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String cnpj = resultSet.getString("cnpj");
				String nome = resultSet.getString("nome");
				String senha = resultSet.getString("senha");
				String cidade = resultSet.getString("cidade");
				String papel = resultSet.getString("papel");

				locadora = new Locadora(cnpj, email, nome, senha, cidade, papel);
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return locadora;
	}

	public List<Locadora> getbyCidade(String cidade) {
		List<Locadora> listaLocadora = new ArrayList<>();
		String sql = "SELECT * from locadora WHERE cidade = ?";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, cidade);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String cnpj = resultSet.getString("cnpj");
				String email = resultSet.getString("email");
				String nome = resultSet.getString("nome");
				String senha = resultSet.getString("senha");
				String papel = resultSet.getString("papel");
				Locadora Locadora = new Locadora(cnpj, email, nome, senha, cidade, papel);
				listaLocadora.add(Locadora);
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaLocadora;
	}

	public List<String> getAllCidade() {
		List<String> listaCidade = new ArrayList<>();
		String sql = "SELECT DISTINCT cidade from Locadora";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String cidade = resultSet.getString("cidade");
				listaCidade.add(cidade);
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaCidade;
	}
}