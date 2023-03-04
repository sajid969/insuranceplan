package com.insurance.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.entities.Plan;
import com.insurance.entities.PlanCategory;
import com.insurance.repository.PlanCategoryRepository;
import com.insurance.repository.PlanRepository;
@Service
public class PlanServiceImpl implements PlanService {
	
	@Autowired
	public PlanRepository planRepository;
	
	@Autowired
	public PlanCategoryRepository planCategoryRepository;
	

	@Override
	public Map<Integer, String> getPlanCategory() {
		List<PlanCategory> category = planCategoryRepository.findAll();
		Map<Integer, String> categoryMap = new HashMap<>();
		category.forEach(cat->categoryMap.put(cat.getPlanCategoryId(), cat.getPlanCategoryName()));
		return categoryMap;
	}

	@Override
	public boolean createPlan(Plan plan) {
		Plan saved = planRepository.save(plan);
		return saved.getPlanCategoryId()!=null;
	}

	@Override
	public List<Plan> getPlans() {
		return planRepository.findAll();
	}

	@Override
	public Plan getPlanById(Integer planId) {
		Optional<Plan> findById = planRepository.findById(planId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		Plan saved = planRepository.save(plan);
		return saved.getPlanId()!=null;
	}

	@Override
	public boolean deletePlanById(Integer planId) {
		boolean status = false;
		try {
			planRepository.deleteById(planId);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean planStatusChange(Integer planId, String status) {
		Optional<Plan> findById = planRepository.findById(planId);
		if(findById.isPresent()) {
			Plan plan = findById.get();
			plan.setActiveSw(status);
			planRepository.save(plan);
			return true;
		}
		return false;
	}

}
