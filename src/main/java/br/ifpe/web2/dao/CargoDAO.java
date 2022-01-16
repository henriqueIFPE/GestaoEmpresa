package br.ifpe.web2.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.web2.model.cadastro.Cargo;

public interface CargoDAO extends JpaRepository<Cargo, Integer>{

	public List<Cargo> findByAtivoIsTrue(Sort sort);
	
	public boolean existsByNome(String nome);
}
