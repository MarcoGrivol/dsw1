package br.ufscar.dc.dsw.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.service.spec.ILocadoraService;
import br.ufscar.dc.dsw.service.spec.ILocacaoService;
import br.ufscar.dc.dsw.service.spec.IUsuarioService;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.security.UsuarioDetails;


@Controller
@RequestMapping("/locacao")
public class LocacaoController {

    @Autowired
	private ILocacaoService service;

	@Autowired
	private ILocadoraService locadoraService;
	
	@Autowired
	private IUsuarioService userService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@GetMapping("/cadastrar")
	public String cadastrar(Locacao locacao ,ModelMap model) {
        model.addAttribute("locadoras",locadoraService.buscarTodos());
		return "locacao/cadastro";
	}
	
	private Usuario getUsuario() {
		UsuarioDetails usuarioDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return usuarioDetails.getUsuario();
	}

	@PostMapping("/salvar")
	public String salvar(Locacao locacao, BindingResult result, RedirectAttributes attr) {
		locacao.setCliente((Cliente)this.getUsuario());
		if (result.hasErrors()) {
	        System.out.println(result);
			return "locacao/cadastro";
		}
		service.salvar(locacao);
		attr.addFlashAttribute("success", "Locadora Inserida com sucesso.");
		return "redirect:/locacao/listar";
	}


	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("locacoes", service.buscarTodos());
		return "locacao/lista";
	}
	
}
