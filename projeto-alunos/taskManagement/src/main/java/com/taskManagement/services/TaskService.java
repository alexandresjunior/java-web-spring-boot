package com.taskManagement.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taskManagement.dto.TaskDTO;
import com.taskManagement.entities.Task;
import com.taskManagement.entities.User;
import com.taskManagement.repositories.TaskRepository;
import com.taskManagement.repositories.UserRepository;
import com.taskManagement.services.exceptions.ControllerNotFoundException;
import com.taskManagement.services.exceptions.DatabaseException;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repository;

	@Autowired
	private UserRepository userRepository;	
	User user;
	
	
	private void buscarUsuarioLogado() {
		Authentication autenticado = SecurityContextHolder.getContext().getAuthentication();
		if(!(autenticado instanceof AnonymousAuthenticationToken)) {
			String uselog = autenticado.getName();
			 user = userRepository.buscarusuariologado(uselog).get(0);
		}
	}
	
	@Transactional(readOnly = true)
	public TaskDTO findTaskById(Integer id) {
	    buscarUsuarioLogado();
	    Long coduser = user.getId();
	    Task obj = repository.findTaskById(id, coduser);
	    if (obj == null) {
	        throw new ControllerNotFoundException("Dados nao encontrados para este usuario");
	    }
	    return new TaskDTO(obj);
	}

	@Transactional(readOnly = true)
	public List<TaskDTO> findAll() {
		 buscarUsuarioLogado();
		    Long coduser = user.getId();
		    
		List<Task> result = repository.findAllTask(coduser);
		return result.stream().map(x -> new TaskDTO(x)).collect(Collectors.toList());
	}
	

	@Transactional(readOnly = true)
	public Page<TaskDTO> findAllPaged(Pageable pageable){
		
		 buscarUsuarioLogado();
		    Long coduser = user.getId();
		
		
		Page<Task> list  = repository.findAllPage(coduser,pageable);
		return list.map(x -> new TaskDTO(x));		
	}
	

	
	@Transactional
	public TaskDTO insert(TaskDTO dto) {
		Task entity =  new Task();
		entity.setCodUser(dto.getCodUser());
		entity.setTitulo(dto.getTitulo());
		entity.setDescricao(dto.getDescricao());
		entity.setDataCriacao(dto.getDataCriacao());
		entity.setStatus(dto.getStatus());
		entity = repository.save(entity);
		
		return new TaskDTO(entity);
	}
	
	
	@Transactional
	public TaskDTO update(Integer id, TaskDTO dto) {
		try {
			Task entity = repository.getOne(id);
			entity.setTitulo(dto.getTitulo());
			entity.setDescricao(dto.getDescricao());
			entity.setStatus("NAO CONCLUIDO");
			entity= repository.save(entity);
		return new TaskDTO(entity);
		}
		
		catch(EntityNotFoundException e) {	
		throw new ControllerNotFoundException("Id not found" + id);
		}
		
	}
	
	
	@Transactional
	public void completeTaskById(Integer id, String status) {
		try {
	    repository.completeTaskById(id,status);
		}
		catch (EmptyResultDataAccessException e ) {
			throw new ControllerNotFoundException("Id not found" + id);
			}
			catch (DataIntegrityViolationException e ) {
			throw new DatabaseException("Integrity violation");
				
			}
	}
	
	
	
	@Transactional
	public void delete(Integer id) {
		try {
			
		repository.deleteTaskById(id);
		}
		catch (EmptyResultDataAccessException e ) {
		throw new ControllerNotFoundException("Id not found" + id);
		}
		catch (DataIntegrityViolationException e ) {
		throw new DatabaseException("Integrity violation");
			
		}
		
	}

}
