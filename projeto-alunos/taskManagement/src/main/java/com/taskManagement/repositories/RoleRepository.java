package com.taskManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskManagement.entities.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {

}
