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

//===========================================================================================//
	@GetMapping("/viewUsers")
	public String getAllHisUsers(Model model){
		
		List<HisUsersEntity> allHisUsersList = hIS_USERService.getAllHisUsers();
		Map<Integer, String> adminrolelist = hIS_USERService.getAllAdminRoles();
		model.addAttribute("adminrole", adminrolelist);
		System.out.println(allHisUsersList);
		  model.addAttribute("allHisUsersList", allHisUsersList);

		return "View_HIS_Users";
	}		
//========================================================================================//
	/*
	 * @GetMapping(value = { "/getHisUsers" })
	 * 
	 * @ResponseBody public Map<Integer, String> getStates(@RequestParam("cid")
	 * Integer countryId) {
	 * 
	 * try { Map<Integer, String> statesByCountry =
	 * hIS_USERService.getStatesByCountry(countryId); return statesByCountry;
	 * 
	 * } catch (Exception e) { return null; }
	 * 
	 * }
	 */
		
	}


