package br.ufscar.dc.dsw.controller;

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
import br.ufscar.dc.dsw.service.spec.ILocacaoService;
import br.ufscar.dc.dsw.service.spec.IUsuarioService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private IClienteService service;
	
	@Autowired
	private IUsuarioService userService;
	
	@Autowired           
	private ILocacaoService locacaoService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@GetMapping("/cadastrar")
	public String cadastrar(Cliente cliente) {
		return "cliente/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("clientes", service.buscarTodos());
		return "cliente/lista";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "cliente/cadastro";
		}
		if (service.buscarClientePorCpf(cliente.getCpf()) != null
				|| userService.buscarUsuarioPorEmail(cliente.getEmail()) != null)
		{
			attr.addFlashAttribute("fail", "cliente.erroJaExiste.label");
			return "redirect:/clientes/cadastrar";
		}
		cliente.setSenha(encoder.encode(cliente.getSenha()));
		service.salvar(cliente);
		attr.addFlashAttribute("success", "cliente.sucessoCadastro.label");
		return "redirect:/clientes/listar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		Cliente cliente = service.buscarPorId(id);
		model.addAttribute("cliente", cliente);
		return "cliente/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "cliente/cadastro";
		}

		service.salvar(cliente);
		attr.addFlashAttribute("success", "cliente.sucessoEditado.label");
		return "redirect:/clientes/listar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		Cliente cliente = service.buscarPorId(id);
		if (!locacaoService.buscarLocacaoPorCliente(cliente).isEmpty())
		{
			model.addAttribute("fail", "cliente.erroExisteLocacao.label");
			return listar(model);
		}
		service.excluir(id);
		model.addAttribute("success", "cliente.sucessoRemovido.label");
		return listar(model);
	}
}