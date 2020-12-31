package br.ufscar.dc.dsw;

import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.dao.IClienteDAO;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.dao.ILocadoraDAO;
import br.ufscar.dc.dsw.dao.IUsuarioDAO;

@SpringBootApplication
public class LocacaoBicicletas2Application {

	public static void main(String[] args) {
		SpringApplication.run(LocacaoBicicletas2Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(BCryptPasswordEncoder encoder, IUsuarioDAO usuarioDAO, IClienteDAO clienteDAO, ILocadoraDAO locadoraDAO) {
		return (args) -> {
			Usuario u1 = new Usuario();
			u1.setEmail("u1@u1.com");
			u1.setNome("u1");
			u1.setSenha(encoder.encode("senhau1"));
			u1.setRole("ROLE_ADMIN");
			u1.setEnabled(true);
			usuarioDAO.save(u1);
			
			Cliente c1 = new Cliente();
			c1.setEmail("c1@c1.com");
			c1.setSenha(encoder.encode("senhac1"));
			c1.setCpf("111.111.111-11");
			c1.setNome("c1");
			c1.setTelefone("(11)1111-1111");
			c1.setSexo("sexoC1");
			c1.setDataNascimento("11/11/1111");
			c1.setRole("ROLE_USER");
			c1.setEnabled(true);
			clienteDAO.save(c1);
			
			Locadora l1 = new Locadora();
			l1.setNome("l1");
			l1.setEmail("l1@l1.com");
			l1.setSenha(encoder.encode("senhal1"));
			l1.setCnpj("11.111.111/1111-11");
			l1.setCidade("cidade1");
			l1.setRole("ROLE_USER");
			l1.setEnabled(true);
			locadoraDAO.save(l1);
		};
	}

}
