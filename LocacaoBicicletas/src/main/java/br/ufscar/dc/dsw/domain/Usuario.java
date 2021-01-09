package br.ufscar.dc.dsw.domain;

public class Usuario {

	private String cpf;
	private String dataNascimento;
	private String email;
	private String login;
	private String nome;
	private String senha;
	private String sexo;
	private String telefone;
	private String papel;

	public Usuario(String cpf) {
		this.cpf = cpf;
	}

	public Usuario(String cpf, String dataNascimento, String email, String login, String nome, String senha,
			String sexo, String telefone, String papel) {
		super();
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.login = login;
		this.nome = nome;
		this.senha = senha;
		this.sexo = sexo;
		this.telefone = telefone;
		this.papel = papel;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String Sexo) {
		this.sexo = Sexo;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getPapel() {
		return this.papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}
}