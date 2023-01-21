package br.com.tarefas.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovaTarefaForm implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		return "forward:cadastraTarefa.jsp";
	}

}
