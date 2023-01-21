package br.com.tarefas.modelo;

import java.time.LocalDateTime;

public class Tarefa {
	private String tarefa;
	private String diaDaSemana;
	private int diaDoMes;
	private String hora;
	private int id;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getTarefa() {
		return tarefa;
	}
	public void setTarefa(String tarefa) {
		this.tarefa = tarefa;
	}
	public String getDiaDaSemana() {
		return diaDaSemana;
	}
	public void setDiaDaSemana(String diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}
	public int getDiaDoMes() {
		return diaDoMes;
	}
	public void setDiaDoMes(int diaDoMes) {
		this.diaDoMes = diaDoMes;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
	
	

}
