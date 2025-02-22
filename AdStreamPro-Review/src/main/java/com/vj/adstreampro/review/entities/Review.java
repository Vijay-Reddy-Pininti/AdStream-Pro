
package com.vj.adstreampro.review.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Reviews")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id")
	private long reviewId;

	@Column(name = "comments")
	private String comments;

	// getters and setters
	public long getReviewId() {
		return reviewId;
	}

	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	// default constructor
	public Review() {
		super();
	}

	// parameterized constructor
	public Review(long reviewId, String comments) {
		super();
		this.reviewId = reviewId;
		this.comments = comments;
	}

	// to string method
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", comments=" + comments + "]";
	}

}
