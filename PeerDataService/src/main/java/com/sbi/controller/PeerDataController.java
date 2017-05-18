package com.sbi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sbi.controller.domain.PeerData;

/**
 * 
 * @author Santosh Kumar Kar
 *
 */
@RestController
public class PeerDataController {
	
		
	@RequestMapping(value="/peerdata", method=RequestMethod.GET)
	public PeerData getPeerData(){
		PeerData pd = new PeerData();
		pd.setId(1L);
		pd.setAge(58);
		pd.setInsurance(800000);
		
		return pd;
	}
	
	
}
