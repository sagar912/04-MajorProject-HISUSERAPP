package com.sagar.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sagar.constants.AppConstants;
import com.sagar.entities.HisUsersEntity;
import com.sagar.services.HIS_USERService;

@Controller
public class View_His_Users_Controllers {
	
@Autowired
private HIS_USERService hIS_USERService;	

//======================================== View His Users ===================================================//
	@GetMapping("/viewUsers")
	public String getAllHisUsers(Model model){
		
		List<HisUsersEntity> allHisUsersList = hIS_USERService.getAllHisUsers();
		//Map<Integer, String> adminrolelist = hIS_USERService.getAllAdminRoles();
		//model.addAttribute("adminrole", adminrolelist);
		System.out.println(allHisUsersList);
		  model.addAttribute("allHisUsersList", allHisUsersList);

		return "View_HIS_Users";
	}		
//==========================================Delete His Users==============================================//
	 @GetMapping("/deleteHisUser")
	   public String deleteContacts(@RequestParam("his_id")int his_usersId,Model model) {
		 
		 boolean deleteHisUser = hIS_USERService.deleteHisUser(his_usersId);
		 if(deleteHisUser) {
			 
			 model.addAttribute("DMsg", "His User Deleted");
			 
		 }
		   return "ACTION_His_User_Success";
	   }
	 
//==========================================Activate His Users==============================================//
	 @GetMapping("/activateHisUser")
	   public String activateHisUser(@RequestParam("his_id")int his_usersId,Model model) {
		 
		 boolean activateHisUser = hIS_USERService.activateHisUser(his_usersId);
		 if(activateHisUser) {
			 
			 model.addAttribute("AMsg", "His User Activated");
			 
		 }
		   return "ACTION_His_User_Success";
	   }
	 
	}


