package com.taskManagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskManagement.entities.Role;
import com.taskManagement.services.RoleService;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {

	@Autowired
	private RoleService service;

	@GetMapping
	public ResponseEntity<List<Role>> findAll() {
		List<Role> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
