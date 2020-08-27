package com.sagar.plan_module.controllers;


import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sagar.plan_module.entities.PlanEntity;
import com.sagar.plan_module.model.Plan;
import com.sagar.plan_module.services.Plan_Service;


@Controller
public class View_Plans_Controllers {
	
	@Autowired
	private Plan_Service plan_Service;
//============================================== View All PLans =============================================//
@GetMapping("/viewAllplans")
public String getAllPlans(HttpServletRequest req ,Model model) {
	
	//Current Page Number & Page Size //
	Integer CurrentPageNumber = 2;
	Integer pageSize = 2;
	
	// Request Page Number //
	
	String PageNumber = req.getParameter("PageNumber");
	
	if(PageNumber!=null && !PageNumber.equals("")) {
		CurrentPageNumber = Integer.parseInt(PageNumber);
	}
	
	Page<PlanEntity> pageData = plan_Service.getAllPlans(pageSize, CurrentPageNumber-1);
	
	List<PlanEntity> entities = pageData.getContent();
	int totalPages = pageData.getTotalPages();
	
	model.addAttribute("AllPlansList", entities);
	model.addAttribute("TotalPages", totalPages);
	model.addAttribute("CurrentPageNumber", CurrentPageNumber);

	return "View_Plans";
}

//==========================================Delete His Plan==============================================//
	 @GetMapping("/deleteplans")
	   public String deletePlans(@RequestParam("planId")int planId,Model model) {
		 
		 boolean deletePlan = plan_Service.deletePlan(planId);
		 if(deletePlan) {
			 
			 model.addAttribute("PDMsg", "Plan Deleted");
			 
		 }
		   return "Action_Plan_Success";
	   }
	 
//==========================================Activate His Plan==============================================//
	 @GetMapping("/activateplan")
	   public String activatePlans(@RequestParam("planId")int planId,Model model) {
		 
		 boolean activatePlan = plan_Service.activatePlan(planId);
		 if(activatePlan) {
			 
			 model.addAttribute("APMsg", "Plan Activated");
			 
		 }
		   return "Action_Plan_Success";
	   }
	
	
//===========================================Edit His Plan==============================================//
		 @GetMapping("/updatePlans")
		   public String EditHisPlans(@RequestParam("planId")int planId,Model model) {
			 Plan plan=new Plan();
			 System.out.println("Code");
			 PlanEntity  editablePlan = plan_Service.editPlan(planId);
			 if(editablePlan !=null) {

				 model.addAttribute("plan", editablePlan);
				 
				   return "Edit_Plan";
			 }else {
				 
				   return "Edit_Plan";

			 }
		   }
		 
	 
}


