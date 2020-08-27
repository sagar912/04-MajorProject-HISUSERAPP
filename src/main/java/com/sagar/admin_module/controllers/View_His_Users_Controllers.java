package com.sagar.admin_module.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sagar.admin_module.constants.AppConstants;
import com.sagar.admin_module.entities.HisUsersEntity;
import com.sagar.admin_module.services.HIS_USERService;
import com.sagar.plan_module.entities.PlanEntity;

@Controller
public class View_His_Users_Controllers {
	
@Autowired
private HIS_USERService hIS_USERService;	

//======================================== View His Users ===================================================//
	@GetMapping("/viewUsers")
	public String getAllHisUsers(HttpServletRequest req,Model model){
		
		//Map<Integer, String> adminrolelist = hIS_USERService.getAllAdminRoles();
		//model.addAttribute("adminrole", adminrolelist);
		
		//Current Page Number & Page Size //
		Integer CurrentPageNumber = 2;
		Integer pageSize = 2;
		
		// Request Page Number //
		
		String PageNumber = req.getParameter("PageNumber");
		
		if(PageNumber!=null && !PageNumber.equals("")) {
			CurrentPageNumber = Integer.parseInt(PageNumber);
		}
		
		Page<HisUsersEntity> pageData = hIS_USERService.getAllHisUsers(pageSize, CurrentPageNumber-1);
		
		List<HisUsersEntity> entities = pageData.getContent();
		int totalPages = pageData.getTotalPages();
		
		model.addAttribute("AllHisUsersList", entities);
		model.addAttribute("TotalPages", totalPages);
		model.addAttribute("CurrentPageNumber", CurrentPageNumber);

		return "View_HIS_Users";
	}		
//==========================================Delete His Users==============================================//
	 @GetMapping("/deleteHisUser")
	   public String deleteContacts(@RequestParam("his_id")int his_usersId,Model model) {
		 
		 boolean deleteHisUser = hIS_USERService.deleteHisUser(his_usersId);
		 if(deleteHisUser) {
			 
			 model.addAttribute("DMsg", "His User Deleted");
			 
		 }
		   return "Action_His_User_Success";
	   }
	 
//==========================================Activate His Users==============================================//
	 @GetMapping("/activateHisUser")
	   public String activateHisUser(@RequestParam("his_id")int his_usersId,Model model) {
		 
		 boolean activateHisUser = hIS_USERService.activateHisUser(his_usersId);
		 if(activateHisUser) {
			 
			 model.addAttribute("AMsg", "His User Activated");
			 
		 }
		   return "Action_His_User_Success";
	   }
	 
	}


