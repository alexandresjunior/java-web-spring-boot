package com.taskManagement.dto;

import java.io.Serializable;
import java.util.Date;

import com.taskManagement.entities.Task;

public class TaskDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private int codUser;
	private String titulo;
	private String descricao;
	private Date dataCriacao;
	private String status;
	
	public TaskDTO() {
		 
	 }


public TaskDTO( Integer id, int codUser, String titulo, Date dataCriacao, String status) {
	
	this.id = id;
	this.codUser = codUser;
	this.titulo = titulo;
	this.dataCriacao = dataCriacao;
	this.status = status;
}




public TaskDTO(String status) {
	this.status = status;
}


public TaskDTO(Task entity) {
	 id = entity.getId();
	 codUser = entity.getCodUser();
	 descricao = entity.getDescricao();
	 titulo = entity.getTitulo();
	 dataCriacao = entity.getDataCriacao();
	 status = entity.getStatus();
	 
	}


public Integer getId() {
	return id;
}


public void setId(Integer id) {
	this.id = id;
}


public int getCodUser() {
	return codUser;
}


public void setCodUser(int codUser) {
	this.codUser = codUser;
}


public String getTitulo() {
	return titulo;
}


public void setTitulo(String titulo) {
	this.titulo = titulo;
}


public String getDescricao() {
	return descricao;
}


public void setDescricao(String descricao) {
	this.descricao = descricao;
}


public Date getDataCriacao() {
	return dataCriacao;
}


public void setDataCriacao(Date dataCriacao) {
	this.dataCriacao = dataCriacao;
}


public String getStatus() {
	return status;
}


public void setStatus(String status) {
	this.status = status;
}



}


