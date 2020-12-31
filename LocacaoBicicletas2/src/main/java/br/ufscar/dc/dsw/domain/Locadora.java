package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Locadora")
public class Locadora extends Usuario
{
	@NotBlank
	@Size(min = 18, max = 18)
	@Column(nullable = false, unique = true, length = 18)
	private String cnpj;
	
	@NotBlank
	@Size(min = 5, max = 32)
	@Column(nullable = false, unique = false, length = 32)
	private String cidade;
	
	public Locadora() {
		super();
	}

	public Locadora(String email, String senha, String nome) {
		super(email, senha, nome);
	}
	
	public String getCnpj()
	{
		return this.cnpj;
	}
	
	public void setCnpj(String cnpj)
	{
		this.cnpj = cnpj;
	}
	
	public String getCidade()
	{
		return this.cidade;
	}
	
	public void setCidade(String cidade)
	{
		this.cidade = cidade;
	}
}