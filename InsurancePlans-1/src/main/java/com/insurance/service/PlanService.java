/**
 * 
 */
package com.insurance.service;

import java.util.List;
import java.util.Map;

import com.insurance.entities.Plan;

/**
 * @author Sajid Ahamad Shaik
 *
 */
public interface PlanService {
	
	public Map<Integer, String> getPlanCategory();
	
	public boolean createPlan(Plan plan);
	
	public List<Plan> getPlans();
	
	public Plan getPlanById(Integer planId);
	
	public boolean updatePlan(Plan plan);
	
	public boolean deletePlanById(Integer planId);
	
	public boolean planStatusChange(Integer planId, String status);

}
