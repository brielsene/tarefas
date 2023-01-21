package br.com.tarefas.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tarefas.modelo.Banco;

public class ListaTarefas implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Banco banco = new Banco();
		request.setAttribute("listaTarefa", banco.getListaTarefa());
		
		return "forward:listaTarefas.jsp";
	}

}
