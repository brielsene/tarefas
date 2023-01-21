package br.com.tarefas.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tarefas.modelo.Banco;

public class RemoveTarefa implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Banco banco = new Banco();
		banco.removeTarefaPeloId(Integer.valueOf(request.getParameter("id")));
		
		return "redirect:controller?acao=ListaTarefas";
	}

}
