package br.com.tarefas.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tarefas.modelo.Banco;
import br.com.tarefas.modelo.Tarefa;

public class NovaTarefa implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Banco banco = new Banco();
		Tarefa tarefa = new Tarefa();
		tarefa.setTarefa(request.getParameter("tarefa"));
		tarefa.setHora(request.getParameter("horaDoDia"));
		tarefa.setDiaDaSemana(request.getParameter("diaDaSemana"));
		tarefa.setDiaDoMes(Integer.valueOf(request.getParameter("diaDoMes")));
		banco.adicionaTarefa(tarefa);
		
		return "redirect:controller?acao=ListaTarefas";
	}

}
