package com.sagar.admin_module.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sagar.admin_module.constants.AppConstants;
import com.sagar.admin_module.entities.HisUsersEntity;
import com.sagar.admin_module.model.HIS_USERS;
import com.sagar.admin_module.services.HIS_USERService;

@Controller
public class View_His_Users_Controllers {

	@Autowired
	private HIS_USERService hIS_USERService;

//======================================== View His Users ===================================================//
	@PostMapping("/viewUsersA")
	public String getAllHisUsers(@RequestParam("adminRoleId") String admin, Model model) {
		
System.out.println("In method");		
	
		 if(admin.endsWith("Admin")) {
			int i=1;
			List<HisUsersEntity> allHisUsersList = hIS_USERService.findByAdminRoleId(i);
		
			allHisUsersList.stream().forEachOrdered(games -> 
			
			games.getAdminRoleId()
					);  

			if(i==1) {
				
				model.addAttribute("adminRoleId", "Admin");
			}else {
			
				model.addAttribute("adminRoleId", "CaseWorker");

			}
	     	model.addAttribute("allHisUsersList", allHisUsersList);
	     
			return "View_HIS_Users";

		}
		
		else{
			int i=2;
			List<HisUsersEntity> allHisUsersList = hIS_USERService.findByAdminRoleId(i);
			model.addAttribute("allHisUsersList", allHisUsersList);
			return "View_HIS_Users";

		}
		
	


	//	} 


		
	}

//======================================== View His Users ===================================================//
	
	 @GetMapping("/viewUsers")
	  
	 public String getAllHisUser(Model model,HIS_USERS hIS_USERS){
	  
	  
			List<HisUsersEntity> allHisUsersList = hIS_USERService.getAllHisUsers();
			Map<Integer, String> adminrolelist = hIS_USERService.getAllAdminRoles();
			model.addAttribute("adminrole", adminrolelist);
			model.addAttribute("hIS_USERS", hIS_USERS);
			
			System.out.println(allHisUsersList);
			model.addAttribute("allHisUsersList", allHisUsersList);

			return "View_HIS_Users";
	  }
	 
//==========================================Delete His Users==============================================//
	@GetMapping("/deleteHisUser")
	public String deleteContacts(@RequestParam("his_id") int his_usersId, Model model) {

		boolean deleteHisUser = hIS_USERService.deleteHisUser(his_usersId);
		if (deleteHisUser) {

			model.addAttribute("DMsg", "His User Deleted");

		}
		return "Action_His_User_Success";
	}

//==========================================Activate His Users==============================================//
	@GetMapping("/activateHisUser")
	public String activateHisUser(@RequestParam("his_id") int his_usersId, Model model) {

		boolean activateHisUser = hIS_USERService.activateHisUser(his_usersId);
		if (activateHisUser) {

			model.addAttribute("AMsg", "His User Activated");

		}
		return "Action_His_User_Success";
	}

}
