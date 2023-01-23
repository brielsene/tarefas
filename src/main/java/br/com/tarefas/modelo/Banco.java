package br.com.tarefas.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Tarefa> listaTarefa = new ArrayList<>();
	private static int chaveSequencial = 1;
	private static List<Usuario> listaUsuario = new ArrayList<>();

	static {
		/**
		 * adição de tarefas
		 */

		Tarefa tarefa = new Tarefa();
		tarefa.setTarefa("Segunda a sexta");
		tarefa.setDiaDaSemana("Segunda a Sexta");
		tarefa.setDiaDoMes(0);
		tarefa.setHora("14:00 ás 15:30");
		tarefa.setId(chaveSequencial++);
		listaTarefa.add(tarefa);
		
		/**
		 * Adição de usuário admin
		 */
		
		Usuario usuario = new Usuario();
		usuario.setLogin("be");
		usuario.setSenha("111");
		listaUsuario.add(usuario);

	}

	public List<Tarefa> getListaTarefa() {
		return listaTarefa;
	}

	public void adicionaTarefa(Tarefa tarefa) {
		tarefa.setId(chaveSequencial++);
		listaTarefa.add(tarefa);
	}

	public Tarefa procuraTarefaPeloId(Integer id) {
		for (Tarefa tarefa : listaTarefa) {
			if (tarefa.getId() == id) {
				return tarefa;

			}

		}
		return null;
	}

	public void removeTarefaPeloId(Integer id) {
		Iterator<Tarefa> it = listaTarefa.iterator();
		while (it.hasNext()) {
			Tarefa tarefa = it.next();
			if (tarefa.getId() == id) {
				it.remove();
			}
		}
	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : listaUsuario) {
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}

		}
		return null;

	}
	
	public boolean ehIgualSenhaCadastro (String senha, String senha2) {
		if(!(senha.equals(senha2))) {
			return false;
		}
		
		return true;
	}
	
	public void adicionaUsuario(Usuario usuario) {
		listaUsuario.add(usuario);
	}
	
	
}
