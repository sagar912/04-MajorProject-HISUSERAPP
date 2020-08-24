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
	
    boolean updateUser(HisUsersEntity hisUsersEntity);
 
    List<HisUsersEntity> getAllHisUsers();
     
    HIS_USERS getHIS_USERSById(Integer his_usersId);

}