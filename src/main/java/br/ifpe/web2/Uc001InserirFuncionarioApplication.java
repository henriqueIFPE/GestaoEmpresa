package br.ifpe.web2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.ifpe.web2.acesso.UsuarioService;
import br.ifpe.web2.service.CargoService;
import br.ifpe.web2.service.EmpresaService;

@SpringBootApplication
public class Uc001InserirFuncionarioApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Uc001InserirFuncionarioApplication.class, args);
	}

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private CargoService cargoService;
	@Autowired
	private EmpresaService empresaService;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inicializando dados.. ");
		System.out.println("Qtd usuários: " + this.usuarioService.obterQuantidade());
		System.out.println("Criando usuário admin");
		this.usuarioService.criarUsuarioAdmin();
		System.out.println("Qtd usuários: " + this.usuarioService.obterQuantidade());
		
		System.out.println("Criando cargos");
		this.cargoService.criarCargos();
		
		System.out.println("Criando empresas");
		this.empresaService.criarEmpresas();

	}

}
