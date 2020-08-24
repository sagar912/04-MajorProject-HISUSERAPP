package com.sagar.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sagar.constants.AppConstants;
import com.sagar.model.HIS_USERS;
import com.sagar.model.UnlockAccount;
import com.sagar.services.HIS_USERService;

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
	           
	HIS_USERS updateHisById = hIS_USERService.getHIS_USERSById(his_usersId);
	
	model.addAttribute("hIS_USERS", updateHisById);
	
	return "Register_HIS_Users";
}

}