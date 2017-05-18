package com.sbi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbi.controller.domain.Goal;
import com.sbi.controller.domain.Investment;
import com.sbi.controller.domain.PeerData;
import com.sbi.controller.domain.UserDemography;
import com.sbi.controller.domain.ViewMessage;

import service.EurekaServiceDataProvider;

@RestController
/**
 * 
 * @author Santosh Kumar Kar
 *
 */
public class GatewayRestController {
	
	@Autowired
	private EurekaServiceDataProvider  serviceClient;

	@RequestMapping("/investments")
	public ViewMessage<Investment[]> getInvestments() {
		return serviceClient.getAllInvestments();
	}
	
	@RequestMapping("/goals")
	public ViewMessage<Goal[]> getGoals() {
		return serviceClient.getAllGoals();
	}
	
	@RequestMapping("/peerdata")
	public ViewMessage<PeerData> getPeerData() {
		return serviceClient.getPeerData();
	}
	
	@RequestMapping("/demography")
	public ViewMessage<UserDemography> getUserDemography() {
		return serviceClient.getUserDemography();
	}
}
