package br.ifpe.web2.acesso;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.web2.util.ServiceException;
import br.ifpe.web2.util.Util;

@Service
public class UsuarioService {

	private static final String USER123 = "user123";
	
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	public void criarUsuarioAdmin() {
		Usuario usuario = new Usuario();
		usuario.setAtivo(true);
		usuario.setLogin("admin");
		usuario.setSenha("adm123");
		usuario.setPerfil(Perfil.ADMINISTRADOR);
		usuario.setNome("Administrador");
		usuario.setSituacaoUsuario(SituacaoUsuario.ATIVO);
		
		
		try {
			inserirUsuario(usuario);
		} catch (ServiceException e) {
			System.out.println("Usuário admin já existe");
		}
	}

	public void criarUsuarioPadra() {
		Usuario usuario = new Usuario();
		usuario.setAtivo(true);
		usuario.setLogin("henrique");
		usuario.setSenha("henrique123");
		usuario.setPerfil(Perfil.USUARIO_PADRAO);
		usuario.setNome("Henrique");
		usuario.setSituacaoUsuario(SituacaoUsuario.ATIVO);
		
		
		try {
			inserirUsuario(usuario);
		} catch (ServiceException e) {
			System.out.println("Usuário admin já existe");
		}
	}

	public void criarUsuarioConsulta() {
		Usuario usuario = new Usuario();
		usuario.setAtivo(true);
		usuario.setLogin("ranny");
		usuario.setSenha("ranny123");
		usuario.setPerfil(Perfil.APENAS_CONSULTA);
		usuario.setNome("Ranielle");
		usuario.setSituacaoUsuario(SituacaoUsuario.ATIVO);
		
		
		try {
			inserirUsuario(usuario);
		} catch (ServiceException e) {
			System.out.println("Usuário Consulta já existe");
		}
	}
	
	public void inserirUsuario(Usuario usuario) throws ServiceException {
		usuario.setSenha(Util.md5(usuario.getSenha()));
		usuario.setDataCriacao(new Date());
		if (this.usuarioDAO.existsByLogin(usuario.getLogin()) == false) {
			this.usuarioDAO.save(usuario);
		} else {
			throw new ServiceException("Já existe usuário com este login");
		}
	}
	
	public void resetarSenha(String login) throws ServiceException{
		
		Usuario usuario = usuarioDAO.findByLogin(login);
		if (usuario != null) {
			String senha = USER123;
			usuario.setSenha(Util.md5(senha));
			usuarioDAO.save(usuario);
		}else {
			throw new ServiceException("Esse meliante não existe");
		}
		
	}

	public long obterQuantidade() {
		return this.usuarioDAO.count();
	}
	
	
}
