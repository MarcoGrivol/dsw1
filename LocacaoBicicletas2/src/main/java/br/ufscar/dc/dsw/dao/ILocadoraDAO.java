package br.ufscar.dc.dsw.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Locadora;

@SuppressWarnings("unchecked")
public interface ILocadoraDAO extends CrudRepository<Locadora, Long> {
	Locadora findById(long id);
	
	List<Locadora> findAll();
	
	Locadora save(Locadora locadora);
	
	void deleteById(Long id);
}