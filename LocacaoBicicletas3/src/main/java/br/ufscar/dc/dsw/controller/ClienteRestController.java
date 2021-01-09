package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.service.spec.IClienteService;

@CrossOrigin
@RestController
public class ClienteRestController {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private IClienteService service;

	private boolean isJSONValid(String jsonInString) {
		try {
			return new ObjectMapper().readTree(jsonInString) != null;
		} catch (IOException e) {
			return false;
		}
	}

	private void parse(Cliente cliente, JSONObject json) {

		Object id = json.get("id");
		if (id != null) {
			if (id instanceof Integer) {
				cliente.setId(((Integer) id).longValue());
			} else {
				cliente.setId((Long) id);
			}
		}
		cliente.setCpf((String) json.get("cpf"));
		cliente.setDataNascimento((String) json.get("dataNascimento"));
		cliente.setEmail((String) json.get("email"));
		cliente.setNome((String) json.get("nome"));
		cliente.setRole("USER");
		cliente.setSenha(encoder.encode((String) json.get("nome")));
		cliente.setSexo((String) json.get("senha"));
		cliente.setTelefone((String) json.get("telefone"));
	}

	@GetMapping(path = "/clientes")
	public ResponseEntity<List<Cliente>> lista() {
		List<Cliente> lista = service.buscarTodos();
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}

}
