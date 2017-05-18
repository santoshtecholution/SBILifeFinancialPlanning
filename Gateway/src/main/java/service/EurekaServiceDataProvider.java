package service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sbi.controller.domain.Goal;
import com.sbi.controller.domain.Investment;
import com.sbi.controller.domain.PeerData;
import com.sbi.controller.domain.UserDemography;
import com.sbi.controller.domain.ViewMessage;

/**
 * 
 * @author Santosh Kumar Kar
 *
 */
public class EurekaServiceDataProvider {

	@Autowired
	private DiscoveryClient discoveryClient;

	@HystrixCommand(fallbackMethod = "investmentFallbackMethod")
	public ViewMessage<Investment[]> getAllInvestments() {

		List<ServiceInstance> instances = discoveryClient.getInstances("INVESTMENTSERVICE");

		ServiceInstance serviceInstance = instances.get(0);

		String baseUrl = serviceInstance.getUri().toString();

		baseUrl = baseUrl + "/investments";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Investment[]> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), Investment[].class);
		} catch (Exception ex) {
			System.out.println(ex);
		}

		ViewMessage<Investment[]> msg = new ViewMessage<>();
		ObjectMapper mapper = new ObjectMapper();
		Investment[] clist = mapper.convertValue(response.getBody(), Investment[].class);
		msg.setContainsError(false);
		msg.setData(clist);

		return msg;
	}

	@HystrixCommand(fallbackMethod = "demographyFallbackMethod")
	public ViewMessage<UserDemography> getUserDemography() {

		List<ServiceInstance> instances = discoveryClient.getInstances("USERDEMOGRAPHICSERVICE");

		ServiceInstance serviceInstance = instances.get(0);

		String baseUrl = serviceInstance.getUri().toString();

		baseUrl = baseUrl + "/demography";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserDemography> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), UserDemography.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}

		ViewMessage<UserDemography> msg = new ViewMessage<>();
		ObjectMapper mapper = new ObjectMapper();
		UserDemography userDemography = mapper.convertValue(response.getBody(), UserDemography.class);
		msg.setContainsError(false);
		msg.setData(userDemography);

		return msg;
	}

	@HystrixCommand(fallbackMethod = "goalFallbackMethod")
	public ViewMessage<Goal[]> getAllGoals() {

		List<ServiceInstance> instances = discoveryClient.getInstances("GOALSERVICE");

		ServiceInstance serviceInstance = instances.get(0);

		String baseUrl = serviceInstance.getUri().toString();

		baseUrl = baseUrl + "/goals";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Goal[]> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), Goal[].class);
		} catch (Exception ex) {
			System.out.println(ex);
		}

		ViewMessage<Goal[]> msg = new ViewMessage<>();
		ObjectMapper mapper = new ObjectMapper();
		Goal[] glist = mapper.convertValue(response.getBody(), Goal[].class);
		msg.setContainsError(false);
		msg.setData(glist);

		return msg;
	}
	
	@HystrixCommand(fallbackMethod = "peerDataFallbackMethod")
	public ViewMessage<PeerData> getPeerData() {

		List<ServiceInstance> instances = discoveryClient.getInstances("PEERDATASERVICE");

		ServiceInstance serviceInstance = instances.get(0);

		String baseUrl = serviceInstance.getUri().toString();

		baseUrl = baseUrl + "/peerdata";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<PeerData> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), PeerData.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}

		ViewMessage<PeerData> msg = new ViewMessage<>();
		ObjectMapper mapper = new ObjectMapper();
		PeerData peerData = mapper.convertValue(response.getBody(), PeerData.class);
		msg.setContainsError(false);
		msg.setData(peerData);

		return msg;
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}

	@SuppressWarnings("unused")
	private ViewMessage<Investment[]> investmentFallbackMethod() {

		ViewMessage<Investment[]> msg = new ViewMessage<>();
		msg.setContainsError(true);
		msg.setMessage("INVESTMENTSERVICE application is down");

		return msg;
	}
	
	@SuppressWarnings("unused")
	private ViewMessage<Goal[]> goalFallbackMethod() {

		ViewMessage<Goal[]> msg = new ViewMessage<>();
		msg.setContainsError(true);
		msg.setMessage("GOALSERVICE application is down");

		return msg;
	}

	@SuppressWarnings("unused")
	private ViewMessage<UserDemography> demographyFallbackMethod() {

		ViewMessage<UserDemography> msg = new ViewMessage<>();
		msg.setContainsError(true);
		msg.setMessage("USERDEMOGRAPHICSERVICE application is down");

		return msg;
	}
	
	@SuppressWarnings("unused")
	private ViewMessage<PeerData> peerDataFallbackMethod() {

		ViewMessage<PeerData> msg = new ViewMessage<>();
		msg.setContainsError(true);
		msg.setMessage("PEERDATASERVICE application is down");

		return msg;
	}
}
