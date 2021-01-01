package br.ufscar.dc.dsw.controller;

import java.util.List;

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
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.service.spec.ILocadoraService;
import br.ufscar.dc.dsw.service.spec.IUsuarioService;


@Controller
@RequestMapping("/locadoras")
public class LocadoraController {

	@Autowired
	private ILocadoraService service;
	
	@Autowired
	private IUsuarioService userService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@GetMapping("/cadastrar")
	public String cadastrar(Locadora locadora) {
		return "locadora/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cidades", service.buscarTodasCidades());
		model.addAttribute("locadoras", service.buscarTodos());
		return "locadora/lista";
	}
	
	@GetMapping("/listar/{cidade}")
	public String listarCidade(@PathVariable("cidade") String cidade, ModelMap model) {
		model.addAttribute("cidades", service.buscarTodasCidades());
		model.addAttribute("locadoras", service.buscarTodasPorCidade(cidade));
		return "locadora/lista";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Locadora locadora, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "locadora/cadastro";
		}

		if (service.buscarLocadoraPorCnpj(locadora.getCnpj()) != null
				|| userService.buscarUsuarioPorEmail(locadora.getEmail()) != null)
		{
			// Acusar erro locadora.jaExiste.label
			return "locadora/cadastro";
		}
		locadora.setSenha(encoder.encode(locadora.getSenha()));
		service.salvar(locadora);
		attr.addFlashAttribute("success", "Locadora Inserida com sucesso.");
		return "redirect:/locadoras/listar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("locadora", service.buscarPorId(id));
		return "locadora/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Locadora locadora, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "locadora/cadastro";
		}

		service.salvar(locadora);
		attr.addFlashAttribute("sucess", "Locadora editado com sucesso.");
		return "redirect:/locadoras/listar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("success", "locadora excluido com sucesso.");
		return listar(model);
	}
}
