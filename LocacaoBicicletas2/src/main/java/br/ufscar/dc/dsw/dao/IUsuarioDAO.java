package br.ufscar.dc.dsw.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.ufscar.dc.dsw.domain.Usuario;

@SuppressWarnings("unchecked")
public interface IUsuarioDAO extends CrudRepository<Usuario, String> {
	// Optional: utilizar isPresent() == True se valor for diferente de nulo
	// 			 e get() para obter 
	Optional<Usuario> findById(String email);
	
	List<Usuario> findAll();
	
	Usuario save(Usuario usuario);
	
	void deleteById(String email);
	
	@Query("SELECT u FROM Usuario u WHERE u.email = :email")
	public Usuario getUserByEmail(@Param("email") String email);
}