package br.com.tarefas.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tarefas.modelo.Banco;
import br.com.tarefas.modelo.Tarefa;

public class MostraTarefa implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
			Banco banco = new Banco();
			Integer id = Integer.valueOf(request.getParameter("id"));
			Tarefa tarefa = banco.procuraTarefaPeloId(id);
			
			request.setAttribute("tarefa", tarefa);
		
		return"forward:alteraTarefa.jsp" ;
	}

}
