package com.sagar.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagar.constants.AppConstants;
import com.sagar.entities.AdminRoleEntity;
import com.sagar.entities.HisUsersEntity;
import com.sagar.model.HIS_USERS;
import com.sagar.repositories.AdminRepo;
import com.sagar.repositories.HIS_USERSRepo;
import com.sagar.utils.EmailUtils;
import com.sagar.utils.PwdUtils;

@Service
public class HIS_USERServiceImpl implements HIS_USERService {
	
    @Autowired
	private AdminRepo adminRepo;
    
    @Autowired
    HIS_USERSRepo hIS_USERSRepo;
    
	@Autowired
	private EmailUtils emailUtils;
    
 //======================================= Load Admin Roles ======================================================//  
	@Override
	public Map<Integer, String> getAllAdminRoles() {

		Map<Integer, String> cmap = new LinkedHashMap<Integer, String>();

		List<AdminRoleEntity> adminroles = adminRepo.findAll();
		
		adminroles.forEach(AdminRoleEntity -> {
			cmap.put(AdminRoleEntity.getAdminRoleId(), AdminRoleEntity.getAdminRoleName());

		});
		
		return cmap;
		
	}
//============================================== Save Users ===================================================//
	@Override
	public boolean saveUser(HIS_USERS hIS_USERS) {
		
	
	
		// ==== SETTING random password for user ========//
		hIS_USERS.setPwd((PwdUtils.generateRandomPassword(AppConstants.TEMP_PWD_LENGTH)));

				// ==== SETTING CONSTANT VALUE IN USER=LOCKED========//
		hIS_USERS.setIsActive(AppConstants.LOCKED_STR);
		
		// ==== SETTING CONSTANT VALUE IN ISDELETED = NO ========//
		hIS_USERS.setIsDeleted(AppConstants.ISDELETED_STR);
	
		HisUsersEntity hisUsersEntity =new HisUsersEntity();
		
		BeanUtils.copyProperties(hIS_USERS, hisUsersEntity);
		
		HisUsersEntity saveUserEntity = hIS_USERSRepo.save(hisUsersEntity);
		
		if(saveUserEntity.getHis_usersId() != 0) {
			
		
			boolean sendUserAccUnlockEmail = emailUtils.SendUserAccUnlockEmail(hIS_USERS);
			 
			return sendUserAccUnlockEmail;

		}
		
		return true;
		
	}
//=============================================== Get Temp Password For unlock Account=====================================//
	@Override
	public HisUsersEntity findByPwd(String xyz) {
		System.out.println(xyz);
		HisUsersEntity hisUsersEntity = hIS_USERSRepo.findBypwd(xyz);
		if (hisUsersEntity != null) {

			hisUsersEntity.setIsActive("Un-Locked");
		}
		return hisUsersEntity;
	}
//========================================== Save Unlock Status with Permanent Pasword   ===================================//
	@Override
	public boolean updateUser(HisUsersEntity hisUsersEntity) {
		HisUsersEntity update = hIS_USERSRepo.save(hisUsersEntity);
		if (update.equals(null)) {
			return false;

		} else {
			return true;
		}
	}
	
//================================================ Get All His Users ========================================================//
	@Override
	public List<HisUsersEntity> getAllHisUsers() {

		
		List<HisUsersEntity> findAllHisUsers = hIS_USERSRepo.findAll();
		
		return findAllHisUsers;
		
	}

//================================================ Update All His Users ========================================================//

	@Override
	public HIS_USERS getHIS_USERSById(Integer his_usersId) {
		
		HIS_USERS hIS_USERS = new HIS_USERS();
		Optional<HisUsersEntity> findById = hIS_USERSRepo.findById(his_usersId);
		
		 if(findById.isPresent()) {
			 HisUsersEntity hisUsersEntity = findById.get();
			    BeanUtils.copyProperties(hisUsersEntity, hIS_USERS);
				return hIS_USERS;
			    }
			    else {
			    	return null;
			    }
		
	}

	
}
