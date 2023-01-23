package br.com.tarefas.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.tarefas.acao.Acao;

/**
 * Servlet implementation class ControllerTarefa
 */
//@WebServlet("/controller")
public class ControllerTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");
		
		
//		HttpSession sessao = request.getSession();
//		boolean usuarioNaoEstaLogado = sessao.getAttribute("usuarioLogado")==null;
//		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("FormUsuario") || paramAcao.equals("CadastroUsuarioForm") || paramAcao.equals("CadastroUsuario"));
//		if(usuarioNaoEstaLogado & ehUmaAcaoProtegida) {
//			response.sendRedirect("controller?acao=FormUsuario");
//			return;
//		}
//		
		String nomeDaClasse = "br.com.tarefas.acao."+paramAcao;
		String nome;
		
		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException
				| ServletException e) {
			throw new ServletException(e);
		}
		
		String[] tipoEEndereco = nome.split(":");
		if(tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoEEndereco[1]);
			rd.forward(request, response);
		}else {
			response.sendRedirect(tipoEEndereco[1]);
		}
		
		
	}

}
