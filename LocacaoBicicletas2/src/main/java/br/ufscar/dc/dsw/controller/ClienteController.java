package br.ufscar.dc.dsw.controller;

import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.service.spec.IClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private IClienteService service;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Cliente cliente)
	{
		return "cliente/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model){
		model.addAttribute("clientes", service.buscarTodos());
		return "cliente/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr)
	{
		if (result.hasErrors())
		{
			return "cliente/cadastro";
		}
		cliente.setSenha(encoder.encode(cliente.getSenha()));
		service.salvar(cliente);
		attr.addFlashAttribute("success", "Cliente Inserida com sucesso.");
		return "redirect:/clientes/listar";
	}
	
	@GetMapping("/editar/{email}")
	public String preEditar(@PathVariable("email") String email, ModelMap model) {
		Optional<Cliente> cliente = service.buscarPorEmail(email);
		if (cliente.isPresent())
		{
			model.addAttribute("cliente", cliente.get());
		}
		return "cliente/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "cliente/cadastro";
		}

		service.salvar(cliente);
		attr.addFlashAttribute("sucess", "Cliente editado com sucesso.");
		return "redirect:/clientes/listar";
	}
	
	@GetMapping("/excluir/{email}")
	public String excluir(@PathVariable("email") String email, ModelMap model)
	{
		service.excluir(email);
		model.addAttribute("success", "Cliente excluido com sucesso.");
		return listar(model);
	}
}
