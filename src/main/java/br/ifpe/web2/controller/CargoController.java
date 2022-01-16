package br.ifpe.web2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.web2.model.cadastro.Cargo;
import br.ifpe.web2.service.CargoService;
import br.ifpe.web2.util.ServiceException;

@Controller
public class CargoController {

	@Autowired
	private CargoService service;
	
	@GetMapping("/cargos")
	public String exibirCargos(Cargo cargo, Model model) {
		model.addAttribute("listaCargos", this.service.listarTodos(true));
		return "/cargo/cargo-form";
	}
	
	@PostMapping("/salvarCargo")
	public String salvarCargo(Cargo cargo, Model model, BindingResult br,
			RedirectAttributes ra) {
		try {
			this.service.inserirCargo(cargo);
		} catch (ServiceException e) {
			br.addError(new ObjectError("global", e.getMessage()));
			return exibirCargos(cargo, model);
		}
		return "redirect:/cargos";
	}
	
	
}
