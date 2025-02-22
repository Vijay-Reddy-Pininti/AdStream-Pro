package com.vj.adstreampro.advertisement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vj.adstreampro.advertisement.entities.Advertisement;
import com.vj.adstreampro.advertisement.services.AdvertisementService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/advertisements")
public class AdvertisementController {

	@Autowired
	private AdvertisementService advertisementService;

	@PostMapping("/addAdvertisement")
	@HystrixCommand
	@ApiOperation(value = "Adds advertisements", response = Advertisement.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully posted advertisement"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public Advertisement addAdvertisement(@RequestBody Advertisement advertisement) {
		/*
		 * Author: Pininti Vijay Reddy
		 * Action: takes input from user in the add advertisement page
		 * output: Details are added to the back-end database
		 * Last Modified on : 05-04-2020
		 */
		return advertisementService.addAdvertisement(advertisement);
	}

	@GetMapping("/getAdvertisementById/{advertisementId}")
	@HystrixCommand
	@ApiOperation(value = "Fetches advertisements By Id", response = Advertisement.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully fetched advertisement based on id"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public Advertisement getAdvertisementById(@PathVariable long advertisementId) {
		/*
		 * Author: Pininti Vijay Reddy
		 * Input: takes the advertisementId
		 * Action: Gets advertisement details from the back-end database based on the
		 * advertisementId
		 * output: Details are fetched from back-end
		 * Last Modified on : 05-04-2020
		 */
		return advertisementService.getAdvertisementById(advertisementId);
	}

	@GetMapping("/getAllAdds")
	@HystrixCommand
	@ApiOperation(value = "Fetches all advertisements", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully fetched all advertisements"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public List<Advertisement> getAllAdds() {
		/*
		 * Author: Pininti Vijay Reddy
		 * Action: fetches the advertisement details as a List
		 * output: Details are fetched from back-end database
		 * Last Modified on : 05-04-2020
		 */
		return advertisementService.getAllAdds();
	}

	@DeleteMapping("/deleteAdvertisement/{advertisementId}")
	@HystrixCommand
	@ApiOperation(value = "Deletes advertisements By Id", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted advertisement based on id"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public String deleteAdvertisement(@PathVariable long advertisementId) {
		/*
		 * Author: Pininti Vijay Reddy
		 * Input: takes the advertisementId
		 * Action: Gets advertisement details from the back-end database based on the
		 * advertisementId and deletes it
		 * output: Details are deleted at the back-end
		 * Last Modified on : 05-04-2020
		 */
		return advertisementService.deleteAdvertisementById(advertisementId);
	}

	@PutMapping("/updateAdvertisement/{advertisementId}")
	@HystrixCommand
	@ApiOperation(value = "Updates advertisements By Id", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated advertisement based on id"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public String updateAdvertisement(@PathVariable long advertisementId, @RequestBody Advertisement advertisement) {
		/*
		 * Author: Pininti Vijay Reddy
		 * Input: takes the advertisementId
		 * Action: Gets advertisement details from the back-end database based on the
		 * advertisementId and updates it
		 * output: Details are updated at the back-end
		 * Last Modified on : 05-04-2020
		 */
		Advertisement add1 = new Advertisement(advertisementId, advertisement.getAdvtDescription(),
				advertisement.getAdvtCategory(), advertisement.getItemAge());
		return advertisementService.updateAdvertisementById(advertisementId, add1);
	}
}
