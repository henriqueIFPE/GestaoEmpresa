package br.ifpe.web2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.web2.model.cadastro.Empresa;
import br.ifpe.web2.service.EmpresaService;
import br.ifpe.web2.util.ServiceException;

@Controller
public class EmpresaController {
	
	
	@Autowired
	private EmpresaService service;

	@GetMapping("/empresas")
	public String exibirEmpresa(Empresa empresa, Model model) {
		

		model.addAttribute("empresas", this.service.findAll());
		
		return "/empresa/empresa-form";
	}
	
	@PostMapping("/salvarEmpresa")
	public String salvaEmpresa(Empresa empresa, Model model, BindingResult br, RedirectAttributes ra) {
		
		try {
			this.service.inserirEmpresa(empresa);
		}catch(ServiceException e ) {
			br.addError(new ObjectError("global", e.getMessage()));
			return exibirEmpresa(empresa, model);
		}
		
		return "redirect:/empresas";
	}
	
	
}
