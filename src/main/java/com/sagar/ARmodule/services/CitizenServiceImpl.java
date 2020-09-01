package com.sagar.ARmodule.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sagar.ARmodule.entities.CitizenEntity;
import com.sagar.ARmodule.model.Citizen;
import com.sagar.ARmodulerepositories.CitizenRepo;
import com.sagar.admin_module.constants.AppConstants;
import com.sagar.admin_module.entities.AdminRoleEntity;
import com.sagar.admin_module.entities.HisUsersEntity;
import com.sagar.admin_module.model.HIS_USERS;
import com.sagar.admin_module.repositories.AdminRepo;
import com.sagar.admin_module.repositories.HIS_USERSRepo;
import com.sagar.admin_module.utils.EmailUtils;
import com.sagar.admin_module.utils.PwdUtils;

@Service
public class CitizenServiceImpl implements CitizenService {


	@Autowired
	private CitizenRepo citizenRepo;

	
	// =======================================// Save Applicants // ======================================================//
	
	@Override
	public boolean saveCitizenPlan(Citizen citizens) {

		CitizenEntity citizenEntity = new CitizenEntity();
		
		BeanUtils.copyProperties(citizens, citizenEntity);

		System.out.println("Entity===>"+citizenEntity);
		CitizenEntity isSaved = citizenRepo.save(citizenEntity);
		
		
		if(isSaved.getApplicantsId() !=null) {
			
			return true;
		}else {
			
			return false ;

		}
	}

	// =======================================// Validate Citizen // ======================================================//





}
