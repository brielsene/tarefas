package br.com.tarefas.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.tarefas.modelo.Banco;
import br.com.tarefas.modelo.Usuario;

public class CadastroUsuario implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Banco banco = new Banco();
		boolean ehIgual = banco.ehIgualSenhaCadastro(request.getParameter("senha"), request.getParameter("senha2"));
		System.out.println(ehIgual);
		if(ehIgual == true) {
			Usuario usuario = new Usuario();
			usuario.setLogin(request.getParameter("login"));
			usuario.setSenha(request.getParameter("senha"));
			banco.adicionaUsuario(usuario);
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuario);
			return "redirect:controller?acao=ListaTarefas";
					
		}else {
			String mensagem = "erro, as senhas não coicidem";
			request.setAttribute("mensagem", mensagem);
			return "forward:cadastroUsuarioForm.jsp";
		}
		
	}

}
