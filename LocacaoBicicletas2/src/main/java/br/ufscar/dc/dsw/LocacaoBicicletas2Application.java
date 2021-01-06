package br.ufscar.dc.dsw;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.dao.IClienteDAO;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.dao.ILocadoraDAO;

@SpringBootApplication
public class LocacaoBicicletas2Application {

	public static void main(String[] args) {
		SpringApplication.run(LocacaoBicicletas2Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(IUsuarioDAO usuarioDAO, IClienteDAO clienteDAO, ILocadoraDAO locadoraDAO, BCryptPasswordEncoder encoder) {
		return (args) -> {

			Usuario u1 = new Usuario();
			u1.setEmail("admin");
			u1.setSenha(encoder.encode("admin"));
			u1.setNome("Administrador");
			u1.setRole("ROLE_ADMIN");
			u1.setEnabled(false);
			usuarioDAO.save(u1);

			Cliente u2 = new Cliente();
			u2.setEmail("c1@c1.com");
			u2.setSenha(encoder.encode("c1"));
			u2.setNome("cliente 1");
			u2.setRole("ROLE_USER");
			u2.setEnabled(false);
			u2.setCpf("111.111.111-11");
			u2.setDataNascimento("11/11/1111");
			u2.setSexo("sexo1");
			u2.setTelefone("(11)1111-1111");
			clienteDAO.save(u2);

			Locadora u3 = new Locadora();
			u3.setEmail("l1@l1.com");
			u3.setSenha(encoder.encode("l1"));
			u3.setNome("locadora 1");
			u3.setRole("ROLE_USER");
			u3.setEnabled(false);
			u3.setCidade("Sao Paulo");
			u3.setCnpj("11.111.111/1111-11");
			locadoraDAO.save(u3);
			
			Locadora u4 = new Locadora();
			u4.setEmail("l2@l2.com");
			u4.setSenha(encoder.encode("l2"));
			u4.setNome("locadora 2");
			u4.setRole("ROLE_USER");
			u4.setEnabled(false);
			u4.setCidade("Ribeirao Preto");
			u4.setCnpj("11.111.111/1111-12");
			locadoraDAO.save(u4);
			
			Locadora u5 = new Locadora();
			u5.setEmail("l3@l3.com");
			u5.setSenha(encoder.encode("l3"));
			u5.setNome("locadora 3");
			u5.setRole("ROLE_USER");
			u5.setEnabled(false);
			u5.setCidade("Sao Paulo");
			u5.setCnpj("11.111.111/1111-13");
			locadoraDAO.save(u5);
		
		};
	}

}
