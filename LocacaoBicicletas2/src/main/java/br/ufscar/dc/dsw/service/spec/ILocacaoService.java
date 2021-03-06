package br.ufscar.dc.dsw.service.spec;

import java.util.List;
import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Locadora;
import java.util.Date;

public interface ILocacaoService {
	Locacao buscarPorId(Long id);
	
	List<Locacao> buscarTodos();
	
	void salvar(Locacao locacao);
	
	void excluir(Long id);
	
	List<Locacao> buscarLocacaoPorCliente(Cliente cliente);
	
	List<Locacao> buscarLocacaoPorLocadora(Locadora Locadora);

	List<Locacao> buscarPorDataeHorario(Date data, Integer horario);
	
}