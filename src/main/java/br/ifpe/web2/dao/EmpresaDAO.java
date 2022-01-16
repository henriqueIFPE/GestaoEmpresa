package br.ifpe.web2.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.web2.model.cadastro.Empresa;

public interface EmpresaDAO extends JpaRepository<Empresa, Integer>{

	public List<Empresa> findByAtivoIsTrue(Sort sort);
	
	public boolean existsByNomeRazaoSocial(String nome);

}
