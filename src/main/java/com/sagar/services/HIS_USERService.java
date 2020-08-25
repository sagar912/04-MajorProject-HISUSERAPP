package com.sagar.services;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.sagar.entities.HisUsersEntity;
import com.sagar.model.HIS_USERS;


@Service
public interface HIS_USERService {

	Map<Integer, String> getAllAdminRoles();

	boolean saveUser(HIS_USERS hIS_USERS);
	
	
	HisUsersEntity findByPwd(String xyz);
	
    boolean updateUserPwd(HisUsersEntity hisUsersEntity);
    

    List<HisUsersEntity> getAllHisUsers();
     
    HisUsersEntity getHIS_USERSById(Integer his_usersId);
    
    boolean deleteHisUser(Integer his_usersId);

	boolean activateHisUser(int his_usersId);

	boolean saveupdatedUser(HIS_USERS hIS_USERS);

}