package br.ufscar.dc.dsw;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.dao.IClienteDAO;
import br.ufscar.dc.dsw.dao.ILocacaoDAO;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.dao.ILocadoraDAO;

@SpringBootApplication
public class LocacaoBicicletas3Application {

	public static void main(String[] args) {
		SpringApplication.run(LocacaoBicicletas3Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(IUsuarioDAO usuarioDAO, IClienteDAO clienteDAO, 
								 ILocadoraDAO locadoraDAO, ILocacaoDAO locacaoDAO, 
								 BCryptPasswordEncoder encoder) {
		return (args) -> {

			Usuario u1 = new Usuario();
			u1.setEmail("admin@admin.com");
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
			u2.setCpf("986.187.740-14");
			u2.setDataNascimento("11/11/1111");
			u2.setSexo("sexo1");
			u2.setTelefone("(11)1111-1111");
			clienteDAO.save(u2);

			Locadora u3 = new Locadora();
			u3.setEmail("l1@l1.com");
			u3.setSenha(encoder.encode("l1"));
			u3.setNome("locadora 1");
			u3.setRole("ROLE_LOCADORA");
			u3.setEnabled(false);
			u3.setCidade("Sao Paulo");
			u3.setCnpj("16.305.638/0001-70");
			locadoraDAO.save(u3);
			
			Locadora u4 = new Locadora();
			u4.setEmail("l2@l2.com");
			u4.setSenha(encoder.encode("l2"));
			u4.setNome("locadora 2");
			u4.setRole("ROLE_LOCADORA");
			u4.setEnabled(false);
			u4.setCidade("Ribeirao Preto");
			u4.setCnpj("03.543.141/0001-49");
			locadoraDAO.save(u4);
			
			Locadora u5 = new Locadora();
			u5.setEmail("l3@l3.com");
			u5.setSenha(encoder.encode("l3"));
			u5.setNome("locadora 3");
			u5.setRole("ROLE_LOCADORA");
			u5.setEnabled(false);
			u5.setCidade("Sao Paulo");
			u5.setCnpj("70.756.201/0001-07");
			locadoraDAO.save(u5);
		
			Locacao loc1 = new Locacao();
			loc1.setCliente(u2);
			loc1.setData(new Date(System.currentTimeMillis()));
			loc1.setHorario(12);
			loc1.setLocadora(u3);
			locacaoDAO.save(loc1);
		};
	}

}
