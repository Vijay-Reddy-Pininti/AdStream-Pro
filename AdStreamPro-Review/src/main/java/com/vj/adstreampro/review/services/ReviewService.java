package com.vj.adstreampro.review.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vj.adstreampro.review.entities.Review;
import com.vj.adstreampro.review.repositories.ReviewRepository;

@Service
@Transactional
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	public Review addReview(Review review) {
		/*
		 * Author: Pininti Vijay Reddy
		 * Action: takes input from user in the add review page
		 * output: Details are added to the back-end database
		 * Last Modified on : 05-04-2020
		 */
		return reviewRepository.save(review);
	}

	public Review getReviewById(long reviewId) {
		/*
		 * Author: Pininti Vijay Reddy
		 * Input: takes the advertisementId
		 * Action: Gets review details from the back-end database based on the reviewId
		 * output: Details are fetched from back-end
		 * Last Modified on : 05-04-2020
		 */
		return reviewRepository.findById(reviewId).get();
	}

	public List<Review> getAllReviews() {
		/*
		 * Author: Pininti Vijay Reddy
		 * Action: fetches the review details as a List
		 * output: Details are fetched from back-end database
		 * Last Modified on : 05-04-2020
		 */
		return (List<Review>) reviewRepository.findAll();
	}

	public String deleteReviewById(long reviewId) {
		/*
		 * Author: Pininti Vijay Reddy
		 * Input: takes the reviewId
		 * Action: Gets review details from the back-end database based on the reviewId
		 * and deletes it
		 * output: Details are deleted at the back-end
		 * Last Modified on : 05-04-2020
		 */
		reviewRepository.deleteById(reviewId);
		return "Review deleted successfully";
	}

	public String updateReviewById(long reviewId, Review review) {
		/*
		 * Author: Pininti Vijay Reddy
		 * Input: takes the reviewId
		 * Action: Gets review details from the back-end database based on the reviewId
		 * and updates it
		 * output: Details are updated at the back-end
		 * Last Modified on : 05-04-2020
		 */
		reviewRepository.saveAndFlush(review);
		return " Review Updated Successfully!";
	}
}
