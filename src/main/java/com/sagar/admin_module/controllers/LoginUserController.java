package com.sagar.admin_module.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sagar.admin_module.entities.HisUsersEntity;
import com.sagar.admin_module.model.HIS_USERS;
import com.sagar.admin_module.services.HIS_USERService;

@Controller
public class LoginUserController {

	@Autowired
	private HIS_USERService hIS_USERService;
//============================ Load Login Page =========================================//
	@GetMapping(value= {"/login"})
	public String loadLoginPage(HIS_USERS hIS_USERS,Model model) {
		
		model.addAttribute("hIS_USERS", hIS_USERS);
		return "Login";
	}
	
//============================ Validate Login User =========================================//

	@PostMapping(value= {"/validateUser"})
	public String ValidateLoginUser(HIS_USERS hIS_USERS,Model model) throws Exception {
		
		String his_usersEmail = hIS_USERS.getEmail();
		
		String pwd = hIS_USERS.getPwd();
		
		HisUsersEntity UserAccountFoundByemail = hIS_USERService.findByemail(his_usersEmail);
		
		System.out.println(UserAccountFoundByemail.getPwd());
		
		if(UserAccountFoundByemail.getIsActive() != "LOCKED" ) {
				
			if(UserAccountFoundByemail.getEmail().equals(his_usersEmail) && UserAccountFoundByemail.getPwd().equals(pwd) ) {
				
				if(UserAccountFoundByemail.getAdminRoleId()==1) {
				
				model.addAttribute("Msg", "Welcome to Admin Dashboard");

				return "AdminDashboard";
    			}
				if(UserAccountFoundByemail.getAdminRoleId()==2){
					
					model.addAttribute("Msg", "Welcome to CaseWorker Dashboard");
	
					return "CaseWorkerDashboard";
					}
				
           //=============================  Invalid Credentials ==================//  
				}else {
					
					model.addAttribute("ErrorMsg", "In-Valid Credentials.Please Check UserId & Password.");
					return "Login";
				}
	
//================================================= Account Locked ==========================================//  
			
			if(UserAccountFoundByemail.getIsActive() == "LOCKED") {
				
				model.addAttribute("LockedMsg", "Your Account is Locked.Please Un-locked it.");
				return "Login";
		}
		}
	
		return "Login";
	
	}
	
}
