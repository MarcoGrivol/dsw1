package br.ufscar.dc.dsw.domain;


public class Locacao {

	private String cnpj;
	private String cpf;
	private String data_locacao;
	private String hora;


	public Locacao(String cnpj, String cpf, String data, String hora) {
		super();
		this.cnpj = cnpj;
		this.cpf = cpf;
		this.data_locacao = data;
		this.hora = hora;
	}
	
	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getData() {
		return this.data_locacao;
	}

	public void setData(String data_locacao) {
		this.data_locacao = data_locacao;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

}

