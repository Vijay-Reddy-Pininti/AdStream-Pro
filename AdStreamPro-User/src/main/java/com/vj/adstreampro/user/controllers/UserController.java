package com.vj.adstreampro.user.controllers;

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

import com.vj.adstreampro.user.entities.User;
import com.vj.adstreampro.user.services.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/addUser")
	@HystrixCommand
	@ApiOperation(value = "Adds users", response = User.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully added user"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public User addUser(@RequestBody User user) {
		/*
		 * Author: Pininti Vijay Reddy
		 * Action: takes input from user in the registration form
		 * output: Details are added to the back-end database
		 * Last Modified on : 05-04-2020
		 */
		return userService.addUser(user);
	}

	@GetMapping("/getUserById/{userId}")
	@HystrixCommand
	@ApiOperation(value = "Fetches advertisements By Id", response = User.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully fetched user based on id"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public User getUserById(@PathVariable long userId) {
		/*
		 * Author: Pininti Vijay Reddy
		 * Input: takes the userId
		 * Action: Gets user details from the back-end database based on the userId
		 * output: Details are fetched from back-end
		 * Last Modified on : 05-04-2020
		 */
		return userService.getUserById(userId);
	}

	@GetMapping("/getAllUsers")
	@HystrixCommand
	@ApiOperation(value = "Fetches all users", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully fetched all users"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public List<User> getAllUsers() {
		/*
		 * Author: Pininti Vijay Reddy
		 * Action: fetches the users details as a List
		 * output: Details are fetched from back-end database
		 * Last Modified on : 05-04-2020
		 */
		return userService.getAllUsers();
	}

	@DeleteMapping("/deleteUserById/{userId}")
	@HystrixCommand
	@ApiOperation(value = "Deletes users By Id", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted user based on id"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public String deleteUser(@PathVariable long userId) {
		/*
		 * Author: Pininti Vijay Reddy
		 * Input: takes the userId
		 * Action: Gets user details from the back-end database based on the userId and
		 * deletes it
		 * output: Details are deleted at the back-end
		 * Last Modified on : 05-04-2020
		 */
		return userService.deleteUserById(userId);
	}

	@PutMapping("/updateUserById/{userId}")
	@HystrixCommand
	@ApiOperation(value = "Updates users By Id", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated user based on id"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public String updateUser(@PathVariable long userId, @RequestBody User user) {
		/*
		 * Author: Pininti Vijay Reddy
		 * Input: takes the userId
		 * Action: Gets user details from the back-end database based on the userId and
		 * updates it
		 * output: Details are updated at the back-end
		 * Last Modified on : 05-04-2020
		 */
		User user1 = new User(userId, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(),
				user.getGender(), user.getContact(), user.getLocation(), user.getUserRole());
		return userService.updateUserById(userId, user1);
	}
}
