package br.ufscar.dc.dsw.domain;

public class Usuario {

	private Long id;
	private String papel;
	private String senha;
	private String login;

	public Usuario(Long id) {
		this.id = id;
	}

	public Usuario(String papel, String senha, String login) {
		super();
		this.papel = papel;
		this.senha = senha;
		this.login = login;
	}

	public Usuario(Long id, String papel, String senha, String login) {
		super();
		this.id = id;
		this.papel = papel;
		this.senha = senha;
		this.login = login;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}