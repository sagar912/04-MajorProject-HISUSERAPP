package com.sagar.plan_module.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sagar.plan_module.model.Plan;
import com.sagar.plan_module.services.Plan_Service;

@Controller
public class Register_Plan_Controller {

	@Autowired
	private Plan_Service plan_Service;
//===================================== Load Plan Register Page==================//
	@GetMapping("/loadPlan")
	public String loadPlanPage(Plan plan ,Model model) {
		
		model.addAttribute("plan", plan);
		
		return "Register_Plan";
		
	}
//===================================== Save Plan ==================//

	@PostMapping("/registerPlan")
	public String savePlan(Plan plan ,Model model) {
		
		boolean issavedPlan = plan_Service.savePlan(plan);
		if(issavedPlan) {
			
			model.addAttribute("SaveMsg", "Plan Added Successfully... ");
		
		}else {
			model.addAttribute("ErrorMsg", "Not Saved");

		}
		
		return "Register_Plan";
		
	}
	
}