package br.ufscar.dc.dsw.domain;

public class Usuario {

	private Long id;
	private String CPF;
	private String data_nascimento;
	private String email;
	private String login;
	private String nome;
	private String senha;
	private String sexo;
	private String telefone;
	private String papel;

	public Usuario(Long id) {
		this.id = id;
	}

	public Usuario(String CPF, String data_nascimento, String email, String login, String nome, String senha,
			String sexo, String telefone, String papel) {
		super();
		this.CPF = CPF;
		this.data_nascimento = data_nascimento;
		this.email = email;
		this.login = login;
		this.nome = nome;
		this.senha = senha;
		this.sexo = sexo;
		this.telefone = telefone;
		this.papel = papel;
	}

	public Usuario(Long id, String CPF, String data_nascimento, String email, String login, String nome, String senha,
			String sexo, String telefone, String papel) {
		super();
		this.CPF = CPF;
		this.data_nascimento = data_nascimento;
		this.email = email;
		this.login = login;
		this.nome = nome;
		this.senha = senha;
		this.sexo = sexo;
		this.telefone = telefone;
		this.papel = papel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCPF() {
		return this.CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public String getDataNascimento() {
		return this.data_nascimento;
	}

	public void setDataNascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
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

/*package br.ufscar.dc.dsw.domain;

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
}*/