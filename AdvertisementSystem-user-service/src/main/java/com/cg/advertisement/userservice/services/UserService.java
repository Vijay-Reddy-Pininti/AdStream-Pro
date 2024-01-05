package com.cg.advertisement.userservice.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.advertisement.userservice.entities.User;
import com.cg.advertisement.userservice.repositories.UserRepository;



@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User user) {
		/*
		 	Author: Pininti Vijay Reddy
		 	Action: adds all the user details to the back-end database
		 	output: the user details are added at the back-end
		 	last modified:05-04-2020
		 */
		return userRepository.save(user);
	}
	
	public User getUserById(long userId) {
		/*
	 	Author: Pininti Vijay Reddy
	 	Input: takes the userId
	 	Action: Gets user details from the back-end database based on the userId
	 	output: Details are fetched from back-end
	 	Last Modified on : 05-04-2020
	 */
		return userRepository.findById(userId).get();
	}
		
	public List<User> getAllUsers(){
		/*
	 	Author: Pininti Vijay Reddy
	 	Action: fetches the users details as a List
	 	output: Details are fetched from back-end database
	 	Last Modified on : 05-04-2020
	 */
		return (List<User>)userRepository.findAll();
	}

	public String deleteUserById(long userId) {
		/*
	 	Author: Pininti Vijay Reddy
	 	Input: takes the userId
	 	Action: Gets user details from the back-end database based on the userId and deletes it
	 	output: Details are deleted at the back-end
	 	Last Modified on : 05-04-2020
	 */
		userRepository.deleteById(userId);
		return "User deleted successfully";
	}

	public String updateUserById(long UserId, User user) {
		/*
	 	Author: Pininti Vijay Reddy
	 	Input: takes the userId
	 	Action: Gets user details from the back-end database based on the userId and updates it
	 	output: Details are updated at the back-end
	 	Last Modified on : 05-04-2020
	 */
		userRepository.saveAndFlush(user);
		return " User Details Updated Successfully!";
	}
}
