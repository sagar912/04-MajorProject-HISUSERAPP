package com.sagar.plan_module.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sagar.admin_module.constants.AppConstants;
import com.sagar.admin_module.entities.HisUsersEntity;
import com.sagar.plan_module.entities.PlanEntity;
import com.sagar.plan_module.model.Plan;
import com.sagar.plan_module.repositories.Plan_Repo;


@Service
public class Plan_ServiceImpl implements Plan_Service {

	@Autowired
	private Plan_Repo plan_Repo;

//======================== Save Plan =============================//
	@Override
	public boolean savePlan(Plan plan) {

		PlanEntity planEntity =new PlanEntity();
		
		BeanUtils.copyProperties(plan, planEntity);
		
		planEntity.setIsPlanDeleted(AppConstants.ISDELETED_STR);
		PlanEntity savedPlan = plan_Repo.save(planEntity);
		
		if(savedPlan != null) {
			
			return true;

		}else {
			return false;
		}
	}



//=============================== Get All Plans ==============================//
	
	@Override
	public Page<PlanEntity> getAllPlans(Integer pageSize, Integer pageNo) {
	
	//	public Page<ContactEntity> getAllContacts(Integer pageSize, Integer pageNo) {
			//List<ContactEntity> entities = contactRepo.findAll();
			
			PageRequest page = PageRequest.of(pageNo, pageSize);
			Page<PlanEntity> findAll = plan_Repo.findAll(page);
			
			return findAll;
		}
	


//====================== Delete Plan ===============================//
	@Override
	public boolean deletePlan(Integer planId) {

		 Optional<PlanEntity> findById = plan_Repo.findById(planId);

		if (findById.isPresent()) {
			PlanEntity planEntity = findById.get();

			planEntity.setIsPlanDeleted("YES");

			plan_Repo.save(planEntity);

		}
		return true;
	}


	//====================== Activate Plan ===============================//

	@Override
	public boolean activatePlan(int planId) {
		
		Optional<PlanEntity> findByIdA = plan_Repo.findById(planId);
		
		if (findByIdA.isPresent()) {
			PlanEntity planEntity = findByIdA.get();

			planEntity.setIsPlanDeleted("NO");

			plan_Repo.save(planEntity);

		}
		return true;
	}


//======================================= Edit His Plans =======================================//
	@Override
	public PlanEntity editPlan(int planId) {

		Optional<PlanEntity> findByIdplan = plan_Repo.findById(planId);

		if (findByIdplan.isPresent()) {
			PlanEntity planEntity = findByIdplan.get();
			return planEntity;

		}else {
			return null;
		}
	}

}
