package br.ifpe.web2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.web2.model.cadastro.Funcionario;

public interface FuncionarioDAO extends JpaRepository<Funcionario, Integer>{

	public Funcionario findByCpf(String cpf);

	public boolean existsByCargo(Integer codigo);

	
	
	
	
	
}
