package com.sagar.admin_module.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagar.admin_module.constants.AppConstants;
import com.sagar.admin_module.entities.AdminRoleEntity;
import com.sagar.admin_module.entities.HisUsersEntity;
import com.sagar.admin_module.model.HIS_USERS;
import com.sagar.admin_module.repositories.AdminRepo;
import com.sagar.admin_module.repositories.HIS_USERSRepo;
import com.sagar.admin_module.utils.EmailUtils;
import com.sagar.admin_module.utils.PwdUtils;

@Service
public class HIS_USERServiceImpl implements HIS_USERService {

	private static final String String = null;

	@Autowired
	private AdminRepo adminRepo;

	@Autowired
	HIS_USERSRepo hIS_USERSRepo;

	@Autowired
	private EmailUtils emailUtils;

	// ======================================= Load Admin Roles ======================================================//
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

		HisUsersEntity hisUsersEntity = new HisUsersEntity();

		BeanUtils.copyProperties(hIS_USERS, hisUsersEntity);

		HisUsersEntity saveUserEntity = hIS_USERSRepo.save(hisUsersEntity);

		if (saveUserEntity.getHis_usersId() != 0) {

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
	public boolean updateUserPwd(HisUsersEntity hisUsersEntity) throws Exception {
		
		hisUsersEntity.setPwd((PwdUtils.PasswordencryptMsg(hisUsersEntity.getPwd())));

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
	public HisUsersEntity getHIS_USERSById(Integer his_usersId) {

		Optional<HisUsersEntity> findById = hIS_USERSRepo.findById(his_usersId);

		if (findById.isPresent()) {
			HisUsersEntity hisUsersEntity = findById.get();
			System.out.println("serviveimpl"+ hisUsersEntity);
			return hisUsersEntity;
		} else {
			return null;
		}

	}

//======================================================= Save Updated His Users Info===============================================//

	@Override
	public boolean saveupdatedUser(HIS_USERS hIS_USERS) {

		HisUsersEntity hisUsersEntity = new HisUsersEntity();

		BeanUtils.copyProperties(hIS_USERS, hisUsersEntity);

		HisUsersEntity updatedUserEntity = hIS_USERSRepo.save(hisUsersEntity);

		if (updatedUserEntity.getHis_usersId() != 0) {

			return true;

		} else {
			return false;

		}

	}

//================================================= Delete HIS USERS ==========================================================//

	@Override
	public boolean deleteHisUser(Integer his_usersId) {

		Optional<HisUsersEntity> findById = hIS_USERSRepo.findById(his_usersId);

		if (findById.isPresent()) {
			HisUsersEntity hisUsersEntity = findById.get();

			hisUsersEntity.setIsDeleted("YES");

			hIS_USERSRepo.save(hisUsersEntity);

		}
		return true;
	}

//================================================= Activate HIS USERS ==========================================================//

	@Override
	public boolean activateHisUser(int his_usersId) {

		Optional<HisUsersEntity> findById = hIS_USERSRepo.findById(his_usersId);

		if (findById.isPresent()) {
			HisUsersEntity hisUsersEntity = findById.get();

			hisUsersEntity.setIsDeleted("NO");

			hIS_USERSRepo.save(hisUsersEntity);

		}
		return true;
	}



}
