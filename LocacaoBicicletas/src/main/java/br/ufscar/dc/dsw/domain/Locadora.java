package br.ufscar.dc.dsw.domain;

public class Locadora {

	private String cnpj;
	private String email;
	private String nome;
    private String senha;
	private String cidade;
	private String papel;


	public Locadora(String cnpj) {
		this.cnpj = cnpj;
	}

	public Locadora(String cnpj, String email, String nome, String senha, String cidade, String papel) {
		super();
		this.cnpj = cnpj;
		this.email = email;
		this.nome = nome;
        this.senha = senha;
		this.cidade = cidade;
		this.papel = papel;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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
    
    public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getPapel() {
		return this.papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	
}