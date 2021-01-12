package br.ufscar.dc.dsw.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.service.spec.IClienteService;
import br.ufscar.dc.dsw.service.spec.ILocacaoService;
import br.ufscar.dc.dsw.service.spec.ILocadoraService;


@CrossOrigin
@RestController
public class LocacaoRestController {
	
	@Autowired
	private ILocacaoService service;
	
	@Autowired
	private IClienteService serviceCliente;
	
	@Autowired
	private ILocadoraService serviceLocadora;

	@GetMapping(path = "/locacoes")
	public ResponseEntity<List<Locacao>> lista() {
		List<Locacao> lista = service.buscarTodos();
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping(path = "/locacoes/{id}")
	public ResponseEntity<Locacao> lista(@PathVariable("id") long id) {
		Locacao locacao = service.buscarPorId(id);
		if (locacao == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(locacao);
	}
	
	@GetMapping(path = "/locacoes/clientes/{id}")
	public ResponseEntity<List<Locacao>> listaPorCLiente(@PathVariable("id") long id) {
		Cliente cliente = serviceCliente.buscarPorId(id);
		if (cliente == null)
		{
			return ResponseEntity.notFound().header("CLIENTE", "NOT_FOUND").build();
		}
		List<Locacao> lista = service.buscarLocacaoPorCliente(cliente);
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().header("LISTA DE LOCACAOES", "NOT_FOUND").build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping(path = "/locacoes/locadoras/{id}")
	public ResponseEntity<List<Locacao>> listaPorLocadora(@PathVariable("id") long id) {
		Locadora locadora = serviceLocadora.buscarPorId(id);
		if (locadora == null)
		{
			return ResponseEntity.notFound().header("LOCADORA", "NOT_FOUND").build();
		}
		List<Locacao> lista = service.buscarLocacaoPorLocadora(locadora);
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().header("LISTA DE LOCACAOES", "NOT_FOUND").build();
		}
		return ResponseEntity.ok(lista);
	}
}
