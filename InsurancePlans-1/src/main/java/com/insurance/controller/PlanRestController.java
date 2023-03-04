/**
 * 
 */
package com.insurance.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.constants.AppConstants;
import com.insurance.entities.Plan;
import com.insurance.properties.AppProperties;
import com.insurance.service.PlanService;

/**
 * @author Sajid Ahamad Shaik
 *
 */
@RestController
public class PlanRestController {
	@Autowired 
	public PlanService planservice;
	
	@Autowired 
	public AppProperties appProps;
	
	private Map<String, String> messages;
	@Autowired
	public PlanRestController(PlanService planservice, AppProperties appProps) {
		super();
		this.planservice = planservice;
		this.messages = appProps.getMessages();
	}

	
	
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> getPlansCategory(){
		Map<Integer, String> planCategory = planservice.getPlanCategory();
		return new ResponseEntity<>(planCategory, HttpStatus.OK);
	}
	
	@PostMapping("/createplan")
	public ResponseEntity<String> createPlan(Plan plan){
		String responsemgs=AppConstants.EMPTY_STR;
		boolean isSaved = planservice.createPlan(plan);
		if(isSaved) {
			responsemgs = messages.get("planSaveSuccess");
		}else {
			responsemgs=messages.get("planSaveFail");
		}
		return new ResponseEntity<>(responsemgs, HttpStatus.CREATED);
	}
	
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> getPlans(){
		List<Plan> plans = planservice.getPlans();
		return new ResponseEntity<>(plans, HttpStatus.OK);
	}
	
	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> getPlanById(@PathVariable Integer planId){
		Plan planById = planservice.getPlanById(planId);
		return new ResponseEntity<Plan>(planById, HttpStatus.OK);
	}
	
	@PutMapping("/updateplan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan){
		String responsemgs=AppConstants.EMPTY_STR;
		boolean updatePlan = planservice.updatePlan(plan);
		if(updatePlan) {
			responsemgs = messages.get(AppConstants.PLANSAVESUCCESS);
		}else {
			responsemgs=messages.get(AppConstants.PLANSAVEFAIL);
		}
		return new ResponseEntity<>(responsemgs, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteplan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
		String responsemgs=AppConstants.EMPTY_STR;
		boolean deletePlan = planservice.deletePlanById(planId);
		if(deletePlan) {
			responsemgs = messages.get(AppConstants.PLANDELETESUCCESS);
		}else {
			responsemgs=messages.get(AppConstants.PLANDELETEFAIL);
		}
		return new ResponseEntity<>(responsemgs, HttpStatus.OK);
	}
	
	@PutMapping("/statuschanger/{planId}/{status}")
	public ResponseEntity<String> planStatusChange(@RequestBody Integer planId, String status){
		String responsemgs=AppConstants.EMPTY_STR;
		boolean updatePlanstatus = planservice.planStatusChange(planId, status);
		if(updatePlanstatus) {
			responsemgs = messages.get(AppConstants.PLANSTATUSSUCCESS);
		}else {
			responsemgs=messages.get(AppConstants.PLANSTATUSFAIL);
		}
		return new ResponseEntity<>(responsemgs, HttpStatus.OK);
	}

}
