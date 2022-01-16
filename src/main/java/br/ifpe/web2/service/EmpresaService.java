package br.ifpe.web2.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.ifpe.web2.dao.EmpresaDAO;
import br.ifpe.web2.model.cadastro.Empresa;
import br.ifpe.web2.util.ServiceException;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaDAO empresaDAO;

	public List<Empresa> listarTodos(boolean ativo){
		Sort sort = Sort.by("nomeRazaoSocial");
		if (ativo) {
			return this.empresaDAO.findByAtivoIsTrue(sort);
		} else {
			return this.empresaDAO.findAll(sort);
		}
	}
	
	public void inserirEmpresa(Empresa empresa) throws ServiceException {
		if (this.empresaDAO.existsByNomeRazaoSocial(empresa.getNomeRazaoSocial()) == false) {
			empresa.setAtivo(true);
			empresa.setDataCriacao(new Date());
			this.empresaDAO.save(empresa);			
		} else {
			throw new ServiceException("Já existe Empresa com este nome");
		}
	}
	
	public void criarEmpresas() {
		String nomesEmpresas[] = {"RCA", "Mazen Cia", "Pipocas Bocus"};
		for (String nome : nomesEmpresas) {
			Empresa c = new Empresa();
			c.setNomeRazaoSocial(nome);
			try {
				this.inserirEmpresa(c);
			} catch (ServiceException e) {
				System.out.println("Empresa já existente");
			}
		}
	}

	public List<Empresa> findAll() {
		return empresaDAO.findAll();
	}
	
	
	
}
