package com.vj.adstreampro.advertisement.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Advertisement")
public class Advertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "advertisement_id")
	private long advertisementId;

	@Column(name = "advt_description")
	private String advtDescription;

	@Column(name = "advt_category")
	private String advtCategory;

	@Column(name = "item_age")
	private String itemAge;

	@Column(name = "advt_post_date")
	private Date advtPostDate = new Date();

	// getters and setters
	public long getAdvertisementId() {
		return advertisementId;
	}

	public void setAdvertisementId(long advertisementId) {
		this.advertisementId = advertisementId;
	}

	public String getAdvtDescription() {
		return advtDescription;
	}

	public void setAdvtDescription(String advtDescription) {
		this.advtDescription = advtDescription;
	}

	public String getAdvtCategory() {
		return advtCategory;
	}

	public void setAdvtCategory(String advtCategory) {
		this.advtCategory = advtCategory;
	}

	public String getItemAge() {
		return itemAge;
	}

	public void setItemAge(String itemAge) {
		this.itemAge = itemAge;
	}

	public Date getAdvtPostDate() {
		return advtPostDate;
	}

	public void setAdvtPostDate(Date advtPostDate) {
		this.advtPostDate = advtPostDate;
	}

	// default Constructor
	public Advertisement() {
		super();
	}

	// Parameterized constructor
	public Advertisement(long advertisementId, String advtDescription, String advtCategory, String itemAge,
			Date advtPostDate) {
		super();
		this.advertisementId = advertisementId;
		this.advtDescription = advtDescription;
		this.advtCategory = advtCategory;
		this.itemAge = itemAge;
		this.advtPostDate = advtPostDate;
	}

	// Parameterized constructor
	public Advertisement(long advertisementId, String advtDescription, String advtCategory, String itemAge) {
		super();
		this.advertisementId = advertisementId;
		this.advtDescription = advtDescription;
		this.advtCategory = advtCategory;
		this.itemAge = itemAge;
	}

	// toString method
	@Override
	public String toString() {
		return "Advertisement [advertisementId=" + advertisementId + ", advtDescription=" + advtDescription
				+ ", advtCategory=" + advtCategory + ", itemAge=" + itemAge + ", advtPostDate=" + advtPostDate + "]";
	}

}
