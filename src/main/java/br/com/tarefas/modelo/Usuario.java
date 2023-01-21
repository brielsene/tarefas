package br.com.tarefas.modelo;

public class Usuario {
	
	private String login,senha;
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public boolean ehIgual(String login, String senha) {
		if(!(this.login.equals(login))) {
			return false;
		}
		if(!(this.getSenha().equals(senha))) {
			return false;
		}
		
		return true;
	}

}
