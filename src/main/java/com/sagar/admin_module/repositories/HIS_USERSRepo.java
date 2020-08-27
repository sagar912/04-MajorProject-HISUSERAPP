package com.sagar.admin_module.repositories;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sagar.admin_module.entities.HisUsersEntity;

public interface HIS_USERSRepo extends JpaRepository<HisUsersEntity, Serializable> {

	HisUsersEntity findBypwd(String xyz);
	
	
}

