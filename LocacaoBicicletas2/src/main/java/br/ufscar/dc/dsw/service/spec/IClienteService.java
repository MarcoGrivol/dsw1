package br.ufscar.dc.dsw.service.spec;

import java.util.List;
import java.util.Optional;

import br.ufscar.dc.dsw.domain.Cliente;

public interface IClienteService {
	Optional<Cliente> buscarPorEmail(String email);
	
	List<Cliente> buscarTodos();
	
	void salvar(Cliente cliente);
	
	void excluir(String email);
}
