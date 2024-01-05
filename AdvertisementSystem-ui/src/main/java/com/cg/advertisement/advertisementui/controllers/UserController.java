package com.cg.advertisement.advertisementui.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cg.advertisement.advertisementui.entities.User;
import com.cg.advertisement.advertisementui.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/addUser",method = {RequestMethod.GET,RequestMethod.POST})
	public String ceateUser(@Valid @ModelAttribute("newUser") User user,BindingResult bindingResult) {
		/*
	 	Author: Pininti Vijay Reddy
	 	Action: takes input from user in the registration form
	 	output: Details are added to the back-end database
	 	Last Modified on : 05-04-2020
	 */
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		else {
			userService.createUser(user);
			return "success";
		}
	}
	
	@RequestMapping(value="/getAllUsers", method= RequestMethod.GET)
	public String getAllUsers(Model model) {
		/*
	 	Author: Pininti Vijay Reddy
	 	Action: fetches the users details as a List
	 	output: Details are fetched from back-end database
	 	Last Modified on : 05-04-2020
	 */
		List<User> usersVariable = userService.getAllUsers();
		model.addAttribute("users",usersVariable);
		System.out.println(usersVariable);
		return "view-all-users";
	}
	
	@RequestMapping(value="/deleteUser/{id}", method= { RequestMethod.GET,RequestMethod.DELETE})
	public String deleteUsertById(@PathVariable("id") Long id) {
		/*
	 	Author: Pininti Vijay Reddy
	 	Input: takes the userId
	 	Action: Gets user details from the back-end database based on the userId and deletes it
	 	output: Details are deleted at the back-end
	 	Last Modified on : 05-04-2020
	 */
		userService.deleteUserById(id);
		return "view-all-users";
	}
	
	@RequestMapping(value="/updateUser/{id}", method= { RequestMethod.GET,RequestMethod.PUT})
	public String updateUserById(Model model,@PathVariable("id") Long id){
		/*
	 	Author: Pininti Vijay Reddy
	 	Input: takes the userId
	 	Action: Gets user details from the back-end database based on the userId and updates it
	 	output: Details are updated at the back-end
	 	Last Modified on : 05-04-2020
	 */
		userService.updateUserById(id);
		return "registration";
	}
	
	@RequestMapping(value="/success")
	public String successPage() {
		return "login";
	}
}
