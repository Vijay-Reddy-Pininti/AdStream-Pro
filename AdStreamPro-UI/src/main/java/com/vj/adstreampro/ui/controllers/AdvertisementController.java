package com.vj.adstreampro.ui.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vj.adstreampro.ui.entities.Advertisement;
import com.vj.adstreampro.ui.services.AdvertisementService;

@Controller
@RequestMapping("/advertisements")
public class AdvertisementController {
	@Autowired
	private AdvertisementService advertisementService;

	@RequestMapping(value = "/addAdvertisement", method = { RequestMethod.GET, RequestMethod.POST })
	public String ceate(@Valid @ModelAttribute("newAdvertisement") Advertisement advertisement) {
		/*
		 * Author: Pininti Vijay Reddy
		 * Action: takes input from user in the add advertisement page
		 * output: Details are added to the back-end database
		 * Last Modified on : 05-04-2020
		 */
		advertisementService.createAdvertisement(advertisement);
		return "addAdvertisement";
	}

	@RequestMapping(value = "/getAllAdds", method = RequestMethod.GET)
	public String getAllAdvertisements(Model model) {
		/*
		 * Author: Pininti Vijay Reddy
		 * Action: fetches the advertisement details as a List
		 * output: Details are fetched from back-end database
		 * Last Modified on : 05-04-2020
		 */
		List<Advertisement> adds = advertisementService.getAllAdds();
		model.addAttribute("advertisements", adds);
		return "view-all-adds";
	}

	@RequestMapping(value = "/deleteAdvertisement/{id}", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String deleteAdvertisementById(@PathVariable("id") Long id) {
		/*
		 * Author: Pininti Vijay Reddy
		 * Input: takes the advertisementId
		 * Action: Gets advertisement details from the back-end database based on the
		 * advertisementId and deletes it
		 * output: Details are deleted at the back-end
		 * Last Modified on : 05-04-2020
		 */
		advertisementService.deleteAdvertisementById(id);
		return "view-all-adds";
	}

	@RequestMapping(value = "/updateAdvertisement/{id}", method = { RequestMethod.GET, RequestMethod.PUT })
	public String updateAdvertisementById(@PathVariable("id") Long id) {
		/*
		 * Author: Pininti Vijay Reddy
		 * Input: takes the advertisementId
		 * Action: Gets advertisement details from the back-end database based on the
		 * advertisementId and updates it
		 * output: Details are updated at the back-end
		 * Last Modified on : 05-04-2020
		 */
		// advertisementService.updateAdvertisementById(id);
		return "addAdvertisement";
	}
}
