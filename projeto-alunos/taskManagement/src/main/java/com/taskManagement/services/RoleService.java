package com.taskManagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskManagement.entities.Role;
import com.taskManagement.repositories.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository repository;
	
	public List<Role>findAll(){
		return repository.findAll();
		
	}

}
