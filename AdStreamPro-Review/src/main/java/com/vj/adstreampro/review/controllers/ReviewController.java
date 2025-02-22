package com.vj.adstreampro.review.controllers;

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

import com.vj.adstreampro.review.entities.Review;
import com.vj.adstreampro.review.services.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@PostMapping("/addReview")
	public Review addReview(@RequestBody Review review) {
		/*
		 * Author: Pininti Vijay Reddy
		 * Action: takes input from user in the add review page
		 * output: Details are added to the back-end database
		 * Last Modified on : 05-04-2020
		 */
		return reviewService.addReview(review);
	}

	@GetMapping("/getReviewById/{reviewId}")
	public Review getReviewById(@PathVariable long reviewId) {
		/*
		 * Author: Pininti Vijay Reddy
		 * Input: takes the advertisementId
		 * Action: Gets review details from the back-end database based on the reviewId
		 * output: Details are fetched from back-end
		 * Last Modified on : 05-04-2020
		 */
		return reviewService.getReviewById(reviewId);
	}

	@GetMapping("/getAllReviews")
	public List<Review> getAllReviews() {
		/*
		 * Author: Pininti Vijay Reddy
		 * Action: fetches the review details as a List
		 * output: Details are fetched from back-end database
		 * Last Modified on : 05-04-2020
		 */
		return reviewService.getAllReviews();
	}

	@DeleteMapping("/delete/{reviewId}")
	public String deleteReview(@PathVariable long reviewId) {
		/*
		 * Author: Pininti Vijay Reddy
		 * Input: takes the reviewId
		 * Action: Gets review details from the back-end database based on the reviewId
		 * and deletes it
		 * output: Details are deleted at the back-end
		 * Last Modified on : 05-04-2020
		 */
		return reviewService.deleteReviewById(reviewId);
	}

	@PutMapping("/updateReview/{reviewId}")
	public String updateReview(@PathVariable long reviewId, @RequestBody Review review) {
		/*
		 * Author: Pininti Vijay Reddy
		 * Input: takes the reviewId
		 * Action: Gets review details from the back-end database based on the reviewId
		 * and updates it
		 * output: Details are updated at the back-end
		 * Last Modified on : 05-04-2020
		 */
		Review review1 = new Review(reviewId, review.getComments());
		return reviewService.updateReviewById(reviewId, review1);
	}
}
