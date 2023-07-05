package com.taskManagement.controllers;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.taskManagement.dto.TaskDTO;
import com.taskManagement.services.TaskService;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

	@Autowired
	private TaskService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<TaskDTO> findById(@PathVariable Integer id) {
		TaskDTO dto = service.findTaskById(id);
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping(value = "/lista")
	public ResponseEntity<List<TaskDTO>> findAll() {
		List<TaskDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/page")
	public ResponseEntity<Page<TaskDTO>> findPage(Pageable pageable) {
		Page<TaskDTO> list = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}

	@PostMapping(value = "/newTask")
	public ResponseEntity<TaskDTO> insert(@RequestBody TaskDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<TaskDTO> update(@PathVariable Integer id, @RequestBody TaskDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Void> completeTask(@PathVariable Integer id, @RequestBody Map<String, String> requestBody) {
		String status = requestBody.get("status");
		service.completeTaskById(id, status);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}