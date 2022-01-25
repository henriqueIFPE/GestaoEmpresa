/*package br.ifpe.web2.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.ifpe.web2.model.cadastro.Cargo;

public class CargoValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Cargo.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Cargo cargo = (Cargo) object;	
		
		String nome = cargo.getNome();
		double salario = cargo.getSalario();
		
		if(salario < 1000) {
			errors.rejectValue("salario", "Menor.cargo.salario");
		}
	}

}*/
