package br.ifpe.web2.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.web2.dao.FuncionarioDAO;
import br.ifpe.web2.model.cadastro.Funcionario;
import br.ifpe.web2.util.ServiceException;
import br.ifpe.web2.util.Util;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioDAO funcionarioDAO;
	
	
	
	public <S extends Funcionario> S save(S entity) {
		return funcionarioDAO.save(entity);
	}



	public List<Funcionario> encontrarTudo() {
		return funcionarioDAO.findAll();
	}

	


	public Optional<Funcionario> buscarPorId(Integer id) {
		return funcionarioDAO.findById(id);
	}

	
	

	public void delete(Funcionario entity) {
		funcionarioDAO.delete(entity);
	}
	
	



	public void deleteById(Integer id) {
		funcionarioDAO.deleteById(id);
	}



	public void inserirFuncionario(Funcionario funcionario) throws ServiceException {
		
		Funcionario funcExistente = this.funcionarioDAO.findByCpf(funcionario.getCpf());
		
		if (funcExistente != null) {
			throw new ServiceException("Já existe um funcionário cadastrado com este CPF");
		}
		if (Util.calcularIdade(funcionario.getDataNascimento()) < 18) {
			throw new ServiceException("Funcionário deve ter 18 anos ou mais");
		}
		
		funcionario.setDataCriacao(new Date());
		funcionario.setDataUltimaAtualizacao(new Date());
		this.funcionarioDAO.save(funcionario);
	}



	public boolean existeFuncionario(Integer codigo) {
	
		return false;
	}



	public boolean existsByCargo(Integer codigo) {
		return funcionarioDAO.existsByCargo(codigo);
	}
	
	
}
