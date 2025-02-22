package com.vj.adstreampro.ui.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vj.adstreampro.ui.entities.User;

@Service
public class UserService {
	@Value("${resource.api.user.add}")
	private String addUser;

	@Value("${resource.api.user.getById}/{userId}")
	private String getUserById;

	@Value("${resource.api.user.getAll}")
	private String getAllUsers;

	@Value("${resources.api.user.delete}/{userId}")
	private String deleteUser;

	@Value("${resources.api.user.update}/{userId}")
	private String updateUser;

	@Autowired
	private RestTemplate restTemplate;

	public List<User> getAllUsers() {
		/*
		 * Author: Pininti Vijay Reddy
		 * Action: fetches the users details as a List
		 * output: Details are fetched from back-end database
		 * Last Modified on : 05-04-2020
		 */
		return Arrays.stream(restTemplate.getForObject(getAllUsers, User[].class)).collect(Collectors.toList());
	}

	public User createUser(User user) {
		/*
		 * Author: Pininti Vijay Reddy
		 * Action: adds all the user details to the back-end database
		 * output: the user details are added at the back-end
		 * last modified:05-04-2020
		 */
		return restTemplate.postForObject(addUser, user, User.class);
	}

	public void deleteUserById(long userId) {
		/*
		 * Author: Pininti Vijay Reddy
		 * Input: takes the userId
		 * Action: Gets user details from the back-end database based on the userId and
		 * deletes it
		 * output: Details are deleted at the back-end
		 * Last Modified on : 05-04-2020
		 */
		restTemplate.delete(deleteUser, userId);
	}

	public User getUserById(long userId) {
		/*
		 * Author: Pininti Vijay Reddy
		 * Input: takes the userId
		 * Action: Gets user details from the back-end database based on the userId
		 * output: Details are fetched from back-end
		 * Last Modified on : 05-04-2020
		 */
		return restTemplate.getForObject(getUserById, User.class);
	}

	public User updateUserById(long userId) {
		/*
		 * Author: Pininti Vijay Reddy
		 * Input: takes the userId
		 * Action: Gets user details from the back-end database based on the userId and
		 * updates it
		 * output: Details are updated at the back-end
		 * Last Modified on : 05-04-2020
		 */
		User user = getUserById(userId);
		restTemplate.put(updateUser, user.getUserId());
		return new User(userId, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(),
				user.getGender(),
				user.getContact(), user.getLocation(), user.getUserRole());
	}
}
