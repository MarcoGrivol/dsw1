package br.ufscar.dc.dsw;

import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import br.ufscar.dc.dsw.dao.IClienteDAO;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.dao.ILocadoraDAO;

@SpringBootApplication
public class LocacaoBicicletas2Application {

	public static void main(String[] args) {
		SpringApplication.run(LocacaoBicicletas2Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(IClienteDAO clienteDAO, ILocadoraDAO locadoraDAO) {
		return (args) -> {
			Cliente c1 = new Cliente();
			c1.setEmail("c1@c1.com");
			c1.setSenha("c1");
			c1.setCpf("111.111.111-11");
			c1.setNome("c1");
			c1.setTelefone("(11)1111-1111");
			c1.setSexo("sexoC1");
			c1.setDataNascimento("11/11/1111");
			clienteDAO.save(c1);
			
			Locadora l1 = new Locadora();
			l1.setNome("l1");
			l1.setEmail("l1@l1.com");
			l1.setSenha("l1");
			l1.setCnpj("11.111.111/1111-11");
			l1.setCidade("cidade1");
			locadoraDAO.save(l1);
		};
	}

}
