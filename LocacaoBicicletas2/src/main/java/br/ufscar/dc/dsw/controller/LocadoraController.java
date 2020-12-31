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
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.service.spec.ILocadoraService;

@Controller
@RequestMapping("/locadoras")
public class LocadoraController {
	
	@Autowired
	private ILocadoraService service;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Locadora locadora)
	{
		return "locadora/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model){
		model.addAttribute("locadoras", service.buscarTodos());
		return "locadora/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Locadora locadora, BindingResult result, RedirectAttributes attr)
	{
		if (result.hasErrors())
		{
			return "locadora/cadastro";
		}
		locadora.setSenha(encoder.encode(locadora.getSenha()));
		service.salvar(locadora);
		attr.addFlashAttribute("success", "Locadora Inserida com sucesso.");
		return "redirect:/locadoras/listar";
	}
	
	@GetMapping("/editar/{email}")
	public String preEditar(@PathVariable("email") String email, ModelMap model) {
		Optional<Locadora> locadora = service.buscarPorEmail(email);
		if (locadora.isPresent())
		{
			model.addAttribute("locadora", locadora.get());
		}
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
	
	@GetMapping("/excluir/{email}")
	public String excluir(@PathVariable("email") String email, ModelMap model)
	{
		service.excluir(email);
		model.addAttribute("success", "Locadora excluida com sucesso.");
		return listar(model);
	}
}
