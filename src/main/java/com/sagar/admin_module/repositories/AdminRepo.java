package com.sagar.admin_module.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagar.admin_module.entities.AdminRoleEntity;

public interface AdminRepo extends JpaRepository<AdminRoleEntity, Serializable>{

}
