package com.sagar.plan_module.services;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.sagar.plan_module.entities.PlanEntity;
import com.sagar.plan_module.model.Plan;


@Service
public interface Plan_Service {

	boolean savePlan(Plan plan);
	
	 Page<PlanEntity> getAllPlans(Integer pageSize, Integer pageNo);
   
	 boolean deletePlan(Integer planId);

	boolean activatePlan(int planId);

	PlanEntity editPlan(int planId);



	
}