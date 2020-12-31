package br.ufscar.dc.dsw;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.dao.IClienteDAO;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Usuario;

@SpringBootApplication
public class LocacaoBicicletas2Application {

	public static void main(String[] args) {
		SpringApplication.run(LocacaoBicicletas2Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(IClienteDAO dao, BCryptPasswordEncoder encoder) {
		return (args) -> {

			Cliente u1 = new Cliente();
			u1.setEmail("user");
			u1.setSenha(encoder.encode("user"));
			u1.setNome("usuario 1");
			u1.setRole("ROLE_USER");
			u1.setEnabled(true);
			u1.setCpf("111.111.111-11");
			u1.setDataNascimento("11/11/1111");
			u1.setSexo("sexo1");
			u1.setTelefone("(11)1111-1111");
			dao.save(u1);

			Cliente u2 = new Cliente();
			u2.setEmail("admin");
			u2.setSenha(encoder.encode("admin"));
			u2.setNome("usuario 2");
			u2.setRole("ROLE_ADMIN");
			u2.setEnabled(true);
			u2.setCpf("222.222.222-22");
			u2.setDataNascimento("22/22/2222");
			u2.setSexo("sexo2");
			u2.setTelefone("(22)2222-2222");
			dao.save(u2);
		};
	}

}
