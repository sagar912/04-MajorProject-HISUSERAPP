package com.sagar.ARmodule.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.sagar.ARmodule.model.Citizen;
import com.sagar.ARmodule.services.CitizenService;


@Controller
public class CitizenController {
	
	@Autowired
	private CitizenService citizenService;
	
	
	//===============================================Load Form and Set ADMIN ROLES DropDown=================================================//	
		@GetMapping(value = { "/citizen" })
		public String loadForm(Model model) {
			Citizen citizen = new Citizen();
			
			model.addAttribute("Citizen", citizen);
			
			return "RegisterCitizen";
		}
		
//================================================================= Save User ===========================================================//
		
		@PostMapping(value = { "/registerCitizen" })
		public String saveCitizen(@ModelAttribute("Citizen") Citizen citizens,Model model) {
		
				
					 boolean saveCitizenPlan = citizenService.saveCitizenPlan(citizens);
						if(saveCitizenPlan == true) {
			 			model.addAttribute("SaveMsg", "Citizen Info Saved SuccessFully..");
						return "RegisterCitizen";
					}else {
						
						model.addAttribute("SaveMsg", "Citizen Info Saved");
						return "RegisterCitizen";	
					}
			}
			
	
			

		//=============================================== Email Validation ====================================================//

		@GetMapping("/getStateBySSN/{ssn}")
		@ResponseBody
		public  String getState(@PathVariable("ssn") String ssn) {

		  	String REST_ENDPOINT="http://localhost:8084/Citizen/getStateBySSN/{ssn}";

			
			WebClient  webClient= WebClient.create();
			String response  =    webClient.get()
								.uri(REST_ENDPOINT,ssn)
								.retrieve()
								.bodyToMono(String.class)
								.block();
			
			System.out.println(response);
			return response;
			

		}
		}
