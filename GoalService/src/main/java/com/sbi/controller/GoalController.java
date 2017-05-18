package com.sbi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sbi.controller.domain.Goal;

/**
 * 
 * @author Santosh Kumar Kar
 *
 */
@RestController
public class GoalController {
	
		
	@RequestMapping(value="/goals", method=RequestMethod.GET)
	public List<Goal> getGoals(){
		Goal goal1 = new Goal();
		goal1.setId(1L);
		goal1.setGoal("Buying new Home");
		
		Goal goal2 = new Goal();
		goal2.setId(2L);
		goal2.setGoal("Daughter's Marriage");

		List<Goal> list = new ArrayList<>(2);
		list.add(goal1);
		list.add(goal2);
		
		return list;
	}
	
	
}
