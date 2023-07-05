package com.taskManagement.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.taskManagement.entities.User;

public class UserDTO  implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private Long id;
	private String email;
	private String name;
	private String password;
		
	Set<RoleDTO> roles = new HashSet<>();
	
	
	public UserDTO () {
		
	}

	public UserDTO(Long id, String email, String name,String password) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.password = password;
		
	}


	public UserDTO(User entity) {
		
		id = entity.getId();
		email = entity.getEmail();
		name = entity.getName();
		password =  entity.getPassword();
		entity.getRoles().forEach(regra -> this.roles.add(new RoleDTO(regra)));
			
		
	}
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Set<RoleDTO> getRoles() {
		return roles;
	}

	
}
