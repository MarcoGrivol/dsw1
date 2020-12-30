package br.ufscar.dc.dsw.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import br.ufscar.dc.dsw.domain.Cliente;

@SuppressWarnings("unchecked")
public interface IClienteDAO extends CrudRepository<Cliente, String> {
	// Optional: utilizar isPresent() == True se valor for diferente de nulo
	// 			 e get() para obter 
	Optional<Cliente> findById(String email);
	
	List<Cliente> findAll();
	
	Cliente save(Cliente cliente);
	
	void deleteById(String email);
}
