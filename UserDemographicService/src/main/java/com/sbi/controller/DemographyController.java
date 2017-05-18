package com.sbi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sbi.controller.domain.UserDemography;

/**
 * 
 * @author Santosh Kumar Kar
 *
 */
@RestController
public class DemographyController {
	
		
	@RequestMapping(value="/demography", method=RequestMethod.GET)
	public UserDemography getDemography(){
		UserDemography d = new UserDemography();
		d.setId(1L);
		d.setAge(58);
		d.setLocation("Hyderabad");
		d.setName("Amitab Bachhan");
		
		return d;
	}
	
	
}
