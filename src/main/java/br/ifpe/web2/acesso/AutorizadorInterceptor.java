package br.ifpe.web2.acesso;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

public class AutorizadorInterceptor implements HandlerInterceptor {

	private static final boolean CONTROLAR_ACESSO = true;

	private static final String[] RECURSOS_LIVRES = { "/", "/login", "/logout", "/novo-usuario", "/usuarios/form",
			"/usuarios/salvar", "/efetuarLogin", "/acesso-negado" };

	private static final String PAGINA_ACESSO_NEGADO = "/acesso-negado";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(" >>> INFO:: Interceptor antes da chamada <<< ");

		if (!CONTROLAR_ACESSO) {
			return true;
		}

		if (handler instanceof ResourceHttpRequestHandler) {
			return true;
		}

		// Para acessar qualquer pagina dessa aplicação, o usuário precisa estar
		// autenticado

		for (String recurso : RECURSOS_LIVRES) {
			if (request.getRequestURL().toString().endsWith(recurso)) {
				return true;
			}
		}

		if (request.getSession().getAttribute("usuarioLogado") == null) {
			request.getRequestDispatcher(PAGINA_ACESSO_NEGADO).forward(request, response);
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println(" >>> INFO:: Interceptor pós chamada <<< ");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {
		System.out.println(" >>> INFO:: Interceptor depois de completado <<< ");
	}
}
