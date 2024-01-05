package com.cg.advertisement.advertisementui.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.advertisement.advertisementui.entities.Advertisement;

@Service
public class AdvertisementService {
	@Value("${resource.api.advertisement.add}")
	private String addAdvertisement;
	
	@Value("${resource.api.advertisement.getById}/{advertisementId}")
	private String getAdvertisementById;
	
	@Value("${resource.api.advertisement.getAll}")
	private String getAllAdvertisements;
	
	@Value("${resources.api.advertisement.delete}/{advertisementId}")
	private String deleteAdvertisement;
	
	@Value("${resources.api.advertisement.update}/{advertisementId}")
	private String updateAdvertisement;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Advertisement> getAllAdds(){
		/*
	 	Author: Pininti Vijay Reddy
	 	Action: fetches the advertisement details as a List
	 	output: Details are fetched from back-end database
	 	Last Modified on : 05-04-2020
	 */
		return Arrays.stream(restTemplate.getForObject(getAllAdvertisements,Advertisement[].class)).collect(Collectors.toList());
	}
	
	public Advertisement createAdvertisement(Advertisement advertisement) {
		/*
	 	Author: Pininti Vijay Reddy
	 	Action: takes input from user in the add advertisement page
	 	output: Details are added to the back-end database
	 	Last Modified on : 05-04-2020
	 */
		return restTemplate.postForObject(addAdvertisement,advertisement,Advertisement.class);
	}
	
	public void deleteAdvertisementById(long advertisementId) {
		/*
	 	Author: Pininti Vijay Reddy
	 	Input: takes the advertisementId
	 	Action: Gets advertisement details from the back-end database based on the advertisementId and deletes it
	 	output: Details are deleted at the back-end
	 	Last Modified on : 05-04-2020
	 */
		restTemplate.delete(deleteAdvertisement,advertisementId);
	}
	
	public Advertisement findAdvertisementById(long advertisementId) {
		/*
	 	Author: Pininti Vijay Reddy
	 	Input: takes the advertisementId
	 	Action: Gets user details from the back-end database based on the advertisementId
	 	output: Details are fetched from back-end
	 	Last Modified on : 05-04-2020
	 */
		return restTemplate.getForObject(getAdvertisementById, Advertisement.class);
	}
}
