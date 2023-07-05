package com.taskManagement.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taskManagement.dto.RoleDTO;
import com.taskManagement.dto.UserDTO;
import com.taskManagement.dto.UserInsertDTO;
import com.taskManagement.dto.UserUpdateDTO;
import com.taskManagement.entities.Role;
import com.taskManagement.entities.User;
import com.taskManagement.repositories.RoleRepository;
import com.taskManagement.repositories.UserRepository;
import com.taskManagement.services.exceptions.ControllerNotFoundException;
import com.taskManagement.services.exceptions.DatabaseException;

@Service
public class UserService implements UserDetailsService{
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(Pageable pageable){
		Page<User> list =  repository.findAll(pageable);
		return list.map(x-> new UserDTO(x));
				
	}
	
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional <User> obj =  repository.findById(id);
		User entity =  obj.orElseThrow(() -> new ControllerNotFoundException ("Entity not found"));
		return new UserDTO (entity);	
		
	}
		
	@Transactional
	public UserDTO insert (UserInsertDTO dto) {
		User entity = new User();
		copyDtoToEntity(dto,entity);
		entity.setPassword(passwordEncoder .encode(dto.getPassword()));
		entity = repository.save(entity);
		return new UserDTO(entity);
		
	}
	
	private void copyDtoToEntity (UserDTO dto, User entity) {
		
		entity.setEmail(dto.getEmail());
		entity.setName(dto.getName());
		entity.setPassword(passwordEncoder .encode(dto.getPassword()));

		/*entity.getRegras().clear();*/
		for(RoleDTO roleDTO :dto.getRoles()) {
			Role role = roleRepository.getOne(roleDTO.getId());
			entity.getRoles().add(role);
				
		}
	}
	
	
	@Transactional
	public UserDTO update (Long id,UserUpdateDTO dto) {
		try {
			User entity = repository.getOne(id);
			copyDtoToEntity(dto,entity);
			entity = repository.save(entity);
			return new UserDTO(entity);			
		}
		catch (EntityNotFoundException e) {
			throw new ControllerNotFoundException ("Id not found" + id);
		}
		
	
	}


	public void  delete (Long id) {
		
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e ) {
			throw new ControllerNotFoundException("Id not Found" + id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity Violation");
		}
		
	}
	
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			User user = repository.findByEmail(username);
						
			if(user == null) {
				logger.error("usuario nao encontrado" + username);
				throw new UsernameNotFoundException("Usuario não Encontrado");
			}
			
			logger.info("usuario encontrado" + username);
			
			return user;
		}
	
	}
