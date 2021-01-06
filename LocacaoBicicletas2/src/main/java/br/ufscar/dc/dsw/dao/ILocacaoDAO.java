package br.ufscar.dc.dsw.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Locadora;
import java.util.Date;

@SuppressWarnings("unchecked")
public interface ILocacaoDAO extends CrudRepository<Locacao, Long> {
	Locacao findById(long id);
	
	List<Locacao> findAll();
	
	Locacao save(Locacao locadora);
	
    void deleteById(Long id);
    
    @Query("SELECT x FROM Locacao x WHERE x.cliente = :cliente")
    public Locacao getLocacaoByCliente(@Param("cliente") Cliente cliente);

    @Query("SELECT x FROM Locacao x WHERE x.locadora = :locadora")
    public Locacao getLocacaoByLocadora(@Param("locadora") Locadora locadora);

    @Query("SELECT x FROM Locacao x WHERE x.data = :data and x.horario = :horario")
    public List<Locacao> getLocacaoByDataeHorario(@Param("data") Date data,@Param("horario") Integer horario);
}