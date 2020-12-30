package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Cliente")
public class Cliente extends Usuario
{
	@NotBlank
	@Size(min = 14, max = 14)
	@Column(nullable = false, unique = true, length = 14)
	private String cpf;
	
	@NotBlank
	@Size(min = 10, max = 15)
	@Column(nullable = false, unique = false, length = 15)
	private String telefone;
	
	@NotBlank
	@Size(min = 5, max = 20)
	@Column(nullable = false, unique = false, length = 20)
	private String sexo;
	
	@NotBlank
	@Size(min = 10, max = 10)
	@Column(nullable = false, unique = false, length = 10)
	private String dataNascimento;
	
	public String getCpf()
	{
		return this.cpf;
	}
	
	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}
	
	public String getTelefone()
	{
		return this.telefone;
	}
	
	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}
	
	public String getSexo()
	{
		return this.sexo;
	}
	
	public void setSexo(String sexo)
	{
		this.sexo = sexo;
	}

	public String getDataNascimento()
	{
		return this.dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento)
	{
		this.dataNascimento = dataNascimento;
	}
}
