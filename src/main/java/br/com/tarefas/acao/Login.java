package br.com.tarefas.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.tarefas.modelo.Banco;
import br.com.tarefas.modelo.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Banco banco = new Banco();
//		System.out.println("login: "+(request.getParameter("login")+ "(request.getParameter("senha"));
		Usuario usuario = banco.existeUsuario(request.getParameter("login"), request.getParameter("senha"));
		System.out.println();
				
		HttpSession sessao = request.getSession();
		
		
		if (usuario != null) {
			sessao.setAttribute("usuarioLogado", usuario);
			return "redirect:controller?acao=ListaTarefas";
		}else {
			return "redirect:controller?acao=FormUsuario";
		}
		

	}

}
