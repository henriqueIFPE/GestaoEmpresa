package br.ifpe.web2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.web2.model.cadastro.Cargo;
import br.ifpe.web2.service.CargoService;
import br.ifpe.web2.util.ServiceException;
import br.ifpe.web2.validator.CargoValidator;

@Controller
public class CargoController {

	@Autowired
	private CargoService service;
	
	
	//------------------------------------------------------------------------------------//
	/*@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(new CargoValidator());
	}*/	
	
	//------------------------------------------------------------------------------------//
	
	@GetMapping("/cargos")
	public String exibirCargos(Cargo cargo, Model model) {
		model.addAttribute("listaCargos", this.service.listarTodos(true));
		return "/cargo/cargo-form";
	}
	
	@PostMapping("/salvarCargo")
	public String salvarCargo(Cargo cargo, Model model, BindingResult br,RedirectAttributes ra) {
		try {
			this.service.inserirCargo(cargo);
		} catch (ServiceException e) {
			br.addError(new ObjectError("global", e.getMessage()));
			return exibirCargos(cargo, model);
		}
		return "redirect:/cargos";
	}
	
	@GetMapping("/cargoEditar{codigo}")
	public String preEditarCargo(@PathVariable("codigo") Integer codigo, ModelMap model) {

		model.addAttribute("cargo", this.service.buscarPorId(codigo));
		return "cargo/cargo-alterar";
	}

	/*@PostMapping("cargo/editar")
	public String EditarCargo() {
	return null;	
	}*/
	
	@GetMapping("/excluirCargo")
	public String excluirCargo(Integer codigo, RedirectAttributes ra) throws ServiceException {
		
		//try {
			
			this.service.deletarPorId(codigo);
		///	return "redirect:/cargos";
			
		//}catch(ServiceException exception){
		
	//	exception.printStackTrace();
	//	ra.addFlashAttribute("mensagemCargo", exception.getMessage());
		
	//	}
		return "redirect:/cargos";
	}
	
	
}
