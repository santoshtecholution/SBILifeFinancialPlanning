package com.sbi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sbi.controller.domain.Investment;

/**
 * 
 * @author Santosh Kumar Kar
 *
 */
@RestController
public class InvestmentController {
	
		
	@RequestMapping(value="/investments", method=RequestMethod.GET)
	public List<Investment> getInvestments(){
		Investment i1 = new Investment();
		i1.setId(1L);
		i1.setType("Gold");
		i1.setAmount(1000000);

		Investment i2 = new Investment();
		i2.setId(2L);
		i2.setType("Silver");
		i2.setAmount(500000);

		List<Investment> list = new ArrayList<>(2);
		list.add(i1);
		list.add(i2);
		
		return list;
	}
	
	
}
