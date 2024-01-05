package com.cg.advertisement.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.advertisement.entities.Advertisement;
import com.cg.advertisement.repositories.AdvertisementRepository;


@Service
@Transactional
public class AdvertisementService {
	
	@Autowired
	private AdvertisementRepository advertisementRepository;
	
	public Advertisement addAdvertisement(Advertisement advertisement) {
		/*
	 	Author: Pininti Vijay Reddy
	 	Action: takes input from user in the add advertisement page
	 	output: Details are added to the back-end database
	 	Last Modified on : 05-04-2020
	 */
		return advertisementRepository.save(advertisement);
	}
	
	public Advertisement getAdvertisementById(long advertisementId) {
		/*
	 	Author: Pininti Vijay Reddy
	 	Input: takes the advertisementId
	 	Action: Gets user details from the back-end database based on the advertisementId
	 	output: Details are fetched from back-end
	 	Last Modified on : 05-04-2020
	 */
		return advertisementRepository.findById(advertisementId).get();
	}
	
	public List<Advertisement> getAllAdds(){
		/*
	 	Author: Pininti Vijay Reddy
	 	Action: fetches the advertisement details as a List
	 	output: Details are fetched from back-end database
	 	Last Modified on : 05-04-2020
	 */
		return (List<Advertisement>)advertisementRepository.findAll();
	}

	public String deleteAdvertisementById(long advertisementId) {
		/*
	 	Author: Pininti Vijay Reddy
	 	Input: takes the advertisementId
	 	Action: Gets advertisement details from the back-end database based on the advertisementId and deletes it
	 	output: Details are deleted at the back-end
	 	Last Modified on : 05-04-2020
	 */
		advertisementRepository.deleteById(advertisementId);
		return "Advertisement deleted successfully";
	}

	public String updateAdvertisementById(long advertisementId, Advertisement advertisement) {
		/*
	 	Author: Pininti Vijay Reddy
	 	Input: takes the advertisementId
	 	Action: Gets advertisement details from the back-end database based on the advertisementId and updates it
	 	output: Details are updated at the back-end
	 	Last Modified on : 05-04-2020
	 */
		advertisementRepository.saveAndFlush(advertisement);
		return " Advertisement Details Updated Successfully!";
	}
}
