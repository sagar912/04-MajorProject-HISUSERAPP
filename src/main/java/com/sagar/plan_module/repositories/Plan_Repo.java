package com.sagar.plan_module.repositories;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sagar.plan_module.entities.PlanEntity;


public interface Plan_Repo extends JpaRepository<PlanEntity, Serializable> {

	
	
}

