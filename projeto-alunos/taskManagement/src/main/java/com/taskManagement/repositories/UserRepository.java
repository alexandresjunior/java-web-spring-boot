package com.taskManagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.taskManagement.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {

	User findByEmail(String email);

	@Query("from User where email =  ?1")
	public List<User> buscarusuariologado(String email);
		
}
