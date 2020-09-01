package com.sagar.admin_module.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagar.admin_module.entities.HisUsersEntity;

public interface HIS_USERSRepo extends JpaRepository<HisUsersEntity, Serializable> {

	HisUsersEntity findBypwd(String xyz);

	HisUsersEntity findByEmail(String xyz);

	List<HisUsersEntity> findByAdminRoleId(Integer id);
}

