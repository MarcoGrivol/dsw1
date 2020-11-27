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
		String sql = "INSERT INTO Locadora (cnpj, email, nome, senha) VALUES (?, ?, ?, ?,?)";
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
				Locadora locadora = new Locadora(cnpj,email,nome,senha,cidade);
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
		String sql = "DELETE FROM Locadora where cpf = ?";
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
		String sql = "UPDATE locadora SET email = ?, nome = ?, senha = ?, cidade = ?, WHERE cnpj = ?";

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
			if (resultSet.next()) {
				String email = resultSet.getString("email");
				String nome = resultSet.getString("nome");
                String senha = resultSet.getString("senha");
                String cidade = resultSet.getString("cidade");
				locadora = new Locadora (cnpj,email,nome, senha,cidade);
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
		List <Locadora> listaLocadora = new ArrayList<>();
		String sql = "SELECT * from locadora WHERE cidade = ?";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, cidade);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String cnpj = resultSet.getString("cnpj");
				String email = resultSet.getString("email");
				String nome = resultSet.getString("nome");
                String senha = resultSet.getString("senha");
				Locadora Locadora = new Locadora(cnpj, email, nome, senha,cidade);
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
}