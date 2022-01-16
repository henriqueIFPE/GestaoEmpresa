package br.ifpe.web2.acesso;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer>{

	public Usuario findByLoginAndSenha(String login, String senha);
	
	public boolean existsByLogin(String login);
}
