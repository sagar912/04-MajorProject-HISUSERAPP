package com.sagar.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagar.entities.AdminRoleEntity;

public interface AdminRepo extends JpaRepository<AdminRoleEntity, Serializable>{

}
