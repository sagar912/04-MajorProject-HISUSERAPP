package com.sagar.admin_module.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sagar.admin_module.constants.AppConstants;
import com.sagar.admin_module.entities.HisUsersEntity;
import com.sagar.admin_module.model.HIS_USERS;
import com.sagar.admin_module.model.UnlockAccount;
import com.sagar.admin_module.services.HIS_USERService;

@Controller
public class Register_His_Users_Controller {
	
	@Autowired
	private HIS_USERService hIS_USERService;
	
	
	//===============================================Load Form and Set ADMIN ROLES DropDown=================================================//	
		@GetMapping(value = { "/index" })
		public String loadForm(Model model) {
			HIS_USERS hIS_USERS = new HIS_USERS();
				Map<Integer, String> adminrolelist = hIS_USERService.getAllAdminRoles();
				model.addAttribute("adminrole", adminrolelist);
				model.addAttribute("hIS_USERS", hIS_USERS);
			
			return "Register_HIS_Users";
		}
		
//================================================================= Save User ===========================================================//
		
		@PostMapping(value = { "/register" })
		public String saveUser(@ModelAttribute("hIS_USERS") HIS_USERS hIS_USERS,Model model) {
		
			if(hIS_USERS.getHis_usersId() == 0) {
				System.out.println(hIS_USERS);
				boolean saveUser = hIS_USERService.saveUser(hIS_USERS);	
					if(saveUser == true) {
					model.addAttribute("SaveMsg", "User Saved SuccessFully..");
					return "Register_HIS_Users";
				}else {
					
					model.addAttribute("SaveMsg", "User Not Saved");
					return "Register_HIS_Users";	
				}
			}
		//====================update user ===========================//
			if(hIS_USERS.getHis_usersId() != 0){
				
				boolean updatedUserEntity = hIS_USERService.saveupdatedUser(hIS_USERS);	
				if(updatedUserEntity == true) {
				model.addAttribute("SaveMsg", "User Updated SuccessFully..");
				return "Register_HIS_Users";
			}else {
				
				model.addAttribute("SaveMsg", "User Not Updated");
				return "Register_HIS_Users";	
			}	
		}
			return "Register_HIS_Users";
		}
//====================================================== Load Page to Create Permanent Password============================//
		@GetMapping(value = { "/unlockAcc" })
		public String unlockUser(@RequestParam("email") String email, Model model) {
			model.addAttribute("email", email);
			UnlockAccount unlockAcc = new UnlockAccount();
			model.addAttribute("unlockAcc", unlockAcc);

			return AppConstants.UNLOCK_USER_PAGE;
		}
		
//=================================================== Edit His Users =====================================================//
     
@GetMapping(value= {"/updateHisUser"})	
public String editHisUser(@RequestParam("his_id") Integer his_usersId,Model model ) {
	           
	HisUsersEntity updateHisById = hIS_USERService.getHIS_USERSById(his_usersId);
	
	//System.out.println();
	System.out.println("controller"+ updateHisById);
	
	//========================= Admin Role For Already Registered But updating His User ============================//
	Map<Integer, String> adminrolelist = hIS_USERService.getAllAdminRoles();
	model.addAttribute("adminrole", adminrolelist);
	model.addAttribute("hIS_USERS", updateHisById);
	
	return "Register_HIS_Users";
}

}