package br.com.tarefas.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
//@WebFilter("/controller")
public class AutorizacaoFilter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String paramAcao = request.getParameter("acao");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		System.out.println("nome da ação: "+paramAcao);
		
		HttpSession sessao = req.getSession();
		boolean usuarioNaoEstaLogado = sessao.getAttribute("usuarioLogado")==null;
		boolean ehUmaAcaoProtegida = !(paramAcao.equals("CadastroUsuario")||paramAcao.equals("CadastroUsuarioForm")||paramAcao.equals("Login")||paramAcao.equals("FormUsuario"));
		if(usuarioNaoEstaLogado & ehUmaAcaoProtegida) {
			resp.sendRedirect("controller?acao=FormUsuario");
			return;
		}
		
		chain.doFilter(req, resp);
		
	}

	

}
