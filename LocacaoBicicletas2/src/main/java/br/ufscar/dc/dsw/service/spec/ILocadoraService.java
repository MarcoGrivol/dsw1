package br.ufscar.dc.dsw.service.spec;

import java.util.List;
import java.util.Optional;

import br.ufscar.dc.dsw.domain.Locadora;

public interface ILocadoraService {
	Optional<Locadora> buscarPorEmail(String email);
	
	List<Locadora> buscarTodos();
	
	void salvar(Locadora locadora);
	
	void excluir(String email);
}
