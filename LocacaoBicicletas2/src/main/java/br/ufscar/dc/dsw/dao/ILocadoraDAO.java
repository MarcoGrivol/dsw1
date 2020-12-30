package br.ufscar.dc.dsw.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import br.ufscar.dc.dsw.domain.Locadora;

@SuppressWarnings("unchecked")
public interface ILocadoraDAO extends CrudRepository<Locadora, String> {
	// Optional: utilizar isPresent() == True se valor for diferente de nulo
	// 			 e get() para obter 
	Optional<Locadora> findById(String email);
	
	List<Locadora> findAll();
	
	Locadora save(Locadora locadora);
	
	void deleteById(String email);
}
