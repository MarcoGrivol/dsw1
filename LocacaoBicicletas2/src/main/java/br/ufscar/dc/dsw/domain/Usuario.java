package br.ufscar.dc.dsw.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@SuppressWarnings("serial")
@Entity
@Table(name = "Usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends AbstractEntity<Long> {

	@NotBlank
	@Size(min = 2, max = 64)
	@Column(nullable = false, unique = true, length = 64)
	private String email;

	@NotBlank
	@Size(min = 2, max = 64)
	@Column(nullable = false, unique = false, length = 64)
	private String nome;

	@NotBlank
	@Size(min = 2, max = 64)
	@Column(nullable = false, unique = false, length = 64)
	private String senha;

	@NotBlank
	@Column(nullable = false, length = 10)
	private String role;

	@Column(nullable = false)
	private boolean enabled;

	public Usuario() {	
	}

	public Usuario(String email, String senha, String nome) {
		this.email = email;
		this.senha = senha;
		this.nome = nome;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString()
	{
		return "[Id=" + this.getId() + 
					   ", Email=" + this.getEmail() +
					   ", Nome=" + this.getNome() +
					   ", Senha=" + this.getSenha() + "]";
	}
}