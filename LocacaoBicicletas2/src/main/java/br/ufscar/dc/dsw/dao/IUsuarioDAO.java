package br.ufscar.dc.dsw.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import br.ufscar.dc.dsw.domain.Usuario;

@SuppressWarnings("unchecked")
public interface IUsuarioDAO extends CrudRepository<Usuario, String> {
	// Optional: utilizar isPresent() == True se valor for diferente de nulo
	// 			 e get() para obter 
	Optional<Usuario> findById(String email);
	
	List<Usuario> findAll();
	
	Usuario save(Usuario usuario);
	
	void deleteById(String email);
}