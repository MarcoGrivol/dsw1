package br.ufscar.dc.dsw.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.domain.Usuario;
 
public class UsuarioDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private IUsuarioDAO dao;
     
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
    	
        Optional<Usuario> usuario = dao.findById(email);
         
        if (!usuario.isPresent()) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new UsuarioDetails(usuario.get());
    }
}