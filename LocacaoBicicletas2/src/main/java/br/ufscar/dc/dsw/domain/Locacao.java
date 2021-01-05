package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Locadora;

@SuppressWarnings("serial")
@Entity
@Table(name = "Locacao")
public class Locacao extends AbstractEntity<Long> 
{
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="locadora_id")
	private Locadora locadora;
	
	@NotNull
	@Column(nullable = false, unique = false)
	private Date data;

	@NotNull
	@Column(nullable = false, unique = false)
	private Integer horario;

	public Locacao() {
		
	}

	public Locacao(Cliente cliente, Locadora locadora, Date data,Integer horario) {
		this.cliente = cliente;
		this.locadora = locadora;
		this.data = data;
		this.horario = horario;
	}


	public Cliente getCliente()
	{
		return this.cliente;
	}
	
	public void setCliente(Cliente cliente)
	{
		this.cliente = cliente;
	}
	
	public Locadora getLocadora()
	{
		return this.locadora;
	}
	
	public void setLocadora(Locadora locadora)
	{
		this.locadora = locadora;
	}
		
	public Date getData()
	{
		return this.data;
	}
	
	public void setData(Date data)
	{
		this.data = data;
	}

	public Integer getHorario()
	{
		return this.horario;
	}
	
	public void setHorario(Integer horario)
	{
		this.horario = horario;
	}
	
}