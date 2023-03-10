package br.com.tarefas.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tarefas.acao.Acao;

/**
 * Servlet Filter implementation class ControllerFilter
 */
//@WebFilter("/controller")
public class ControllerFilter extends HttpFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
			HttpServletRequest request = (HttpServletRequest)req;
			HttpServletResponse response = (HttpServletResponse)resp;
			
			String paramAcao = request.getParameter("acao");
			String nomeDaClasse = "br.com.tarefas.acao."+paramAcao;
			String nome;
			
			try {
				Class classe = Class.forName(nomeDaClasse);
				Acao acao = (Acao)classe.newInstance();
				nome = acao.executa(request, response);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException
					| ServletException e) {
				throw new ServletException(e);
				
			}
			
			String []tipoEEdenreco = nome.split(":");
			if(tipoEEdenreco[0].equals("forward")) {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/"+tipoEEdenreco[1]);
					rd.forward(request, response);
				
			}else {
				response.sendRedirect(tipoEEdenreco[1]);
			}
		
		
		
	}
}
