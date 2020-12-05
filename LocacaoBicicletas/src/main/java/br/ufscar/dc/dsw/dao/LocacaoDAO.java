package br.ufscar.dc.dsw.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Locacao;

public class LocacaoDAO extends GenericDAO{
	
	public void insert(Locacao locacao) {
		String sql = "INSERT INTO Locacao (cpf, cnpj, data_locacao, hora) VALUES (?, ?, ?, ?)";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			;
			statement = conn.prepareStatement(sql);
			statement.setString(1, locacao.getCpf());
			statement.setString(2, locacao.getCnpj());
			statement.setString(3, locacao.getData());
			statement.setString(4, locacao.getHora());

			statement.executeUpdate();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Locacao> getAll() {
		List<Locacao> listaLocacao = new ArrayList<>();
		String sql = "SELECT * from Locacao";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			// Statement statement = conn.createStatement();
			// ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String cnpj = resultSet.getString("cnpj");
				String cpf  = resultSet.getString("cpf");
				String data_locacao = resultSet.getString("data_locacao");
				String hora = resultSet.getString("hora");
				Locacao locacao = new Locacao(cnpj,cpf, data_locacao,hora);
				listaLocacao.add(locacao);
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaLocacao;
	}

	public void delete(Locacao locacao) {
		String sql = "DELETE FROM Locacao where cnpj = ? AND cpf = ? AND data_locacao = ? AND hora = ?";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, locacao.getCnpj());
			statement.setString(2, locacao.getCpf());
			statement.setString(3, locacao.getData());
			statement.setString(3, locacao.getHora());
			statement.executeUpdate();
			statement.close();
			conn.close();
		} catch (SQLException e) {
		}
	}

//	public void update(Locacao locacao) {
		
//	}

	public List<Locacao> getbyCpf(String cpf) {
		List<Locacao> listaLocacao = new ArrayList<>();
		Locacao locacao = null;
		String sql = "SELECT * from Locacao WHERE cpf = ?";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, cpf);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String cnpj = resultSet.getString("cnpj");
				String data_locacao = resultSet.getString("data_locacao");
				String hora = resultSet.getString("hora");
				
				locacao = new Locacao (cnpj, cpf, data_locacao, hora);
				listaLocacao.add(locacao);
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaLocacao;
	}
	public Locacao getbydata(String data_locacao, String hora) {
		Locacao locacao = null;
		String sql = "SELECT * from Locacao WHERE data_locacao = ? AND hora = ?";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, data_locacao);
			statement.setString(2, hora);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String cpf = resultSet.getString("cpf");
				String cnpj = resultSet.getString("cnpj");
				
				locacao = new Locacao (cnpj, cpf, data_locacao,hora);
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return locacao;
	}
	
	public List<Locacao> getbyCnpj(String cnpj) {
		List<Locacao> listaLocacao = new ArrayList<>();
		Locacao locacao = null;
		String sql = "SELECT * from Locacao WHERE cnpj = ?";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, cnpj);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String cpf = resultSet.getString("cpf");
				String data_locacao = resultSet.getString("data_locacao");
				String hora = resultSet.getString("hora");
				
				locacao = new Locacao (cnpj, cpf, data_locacao, hora);
				listaLocacao.add(locacao);
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaLocacao;
	}

	public Locacao getbydata_cpf(String data_locacao, String hora, String cpf) {
		Locacao locacao = null;
		String sql = "SELECT * from Locacao WHERE data_locacao = ? AND hora = ? AND cpf = ?";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, data_locacao);
			statement.setString(2, hora);
			statement.setString(3, cpf);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String cnpj = resultSet.getString("cnpj");
				
				locacao = new Locacao (cnpj, cpf, data_locacao,hora);
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return locacao;
	}

	public Locacao getbydata_cnpj(String data_locacao, String hora, String cnpj) {
		Locacao locacao = null;
		String sql = "SELECT * from Locacao WHERE data_locacao = ? AND hora = ? AND cnpj = ?";
		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, data_locacao);
			statement.setString(2, hora);
			statement.setString(3, cnpj);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String cpf = resultSet.getString("cpf");
				
				locacao = new Locacao (cnpj, cpf, data_locacao,hora);
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return locacao;
	}
}
