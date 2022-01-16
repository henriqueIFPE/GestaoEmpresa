package br.ifpe.web2.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.ifpe.web2.dao.CargoDAO;
import br.ifpe.web2.model.cadastro.Cargo;
import br.ifpe.web2.util.ServiceException;

@Service
public class CargoService {

	@Autowired
	private CargoDAO cargoDAO;

	public List<Cargo> listarTodos(boolean ativo){
		Sort sort = Sort.by("nome");
		if (ativo) {
			return this.cargoDAO.findByAtivoIsTrue(sort);
		} else {
			return this.cargoDAO.findAll(sort);
		}
	}
	
	public void inserirCargo(Cargo cargo) throws ServiceException {
		if (this.cargoDAO.existsByNome(cargo.getNome()) == false) {
			cargo.setAtivo(true);
			cargo.setDataCriacao(new Date());
			this.cargoDAO.save(cargo);			
		} else {
			throw new ServiceException("Já existe cargo com este nome");
		}
	}
	
	public void criarCargos() {
		String nomesCargos[] = {"Advogado", "Psicólog", "Secretária", "Gerente", "Vendedor"};
		for (String nome : nomesCargos) {
			Cargo c = new Cargo(nome);
			try {
				this.inserirCargo(c);
			} catch (ServiceException e) {
				System.out.println("Cargo já existente");
			}
		}
	}
	
	
	
}
