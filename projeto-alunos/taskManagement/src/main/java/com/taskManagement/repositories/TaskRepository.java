package com.taskManagement.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.taskManagement.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

	@Transactional
	@Query(nativeQuery = true, value = "SELECT ID, COD_USER, DATA_CRIACAO, DESCRICAO, STATUS, TITULO FROM TASK WHERE ID = :id AND COD_USER = :coduser")
	Task findTaskById(@Param("id") int id, @Param("coduser") Long coduser);

	@Transactional
	@Query(nativeQuery = true, value = "SELECT ID, COD_USER, DATA_CRIACAO, DESCRICAO, STATUS, TITULO FROM TASK WHERE COD_USER = :coduser")
	List<Task> findAllTask(@Param("coduser") Long coduser);

	@Transactional
	@Query(nativeQuery = true, value = "SELECT ID, COD_USER, DATA_CRIACAO, DESCRICAO, STATUS, TITULO FROM TASK WHERE COD_USER = :coduser")
	Page<Task> findAllPage(@Param("coduser") Long coduser,  Pageable page);

	@Modifying
	@Query(nativeQuery = true, value = "DELETE FROM TASK WHERE ID = :id")
	void deleteTaskById(@Param("id") int id);
	
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE TASK SET STATUS = :status WHERE ID = :id")
	void completeTaskById(@Param("id") int id, @Param("status") String  status);
	
}
