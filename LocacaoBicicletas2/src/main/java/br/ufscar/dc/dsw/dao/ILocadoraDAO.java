package br.ufscar.dc.dsw.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import br.ufscar.dc.dsw.domain.Locadora;

@SuppressWarnings("unchecked")
public interface ILocadoraDAO extends CrudRepository<Locadora, Long> {
	Locadora findById(long id);
	
	List<Locadora> findAll();
	
	Locadora save(Locadora locadora);
	
	void deleteById(Long id);
	
    @Query("SELECT x FROM Locadora x WHERE x.email = :email")
    public Locadora getLocadoraByEmail(@Param("email") String email);
    
    @Query("SELECT x FROM Locadora x WHERE x.cnpj = :cnpj")
    public Locadora getLocadoraByCnpj(@Param("cnpj") String cpnj);
}