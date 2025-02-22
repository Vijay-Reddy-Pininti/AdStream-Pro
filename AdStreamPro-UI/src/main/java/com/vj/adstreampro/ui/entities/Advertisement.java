package com.vj.adstreampro.ui.entities;

import java.util.Date;

public class Advertisement {
	private long advertisementId;
	private String advtDescription;
	private String advtCategory;
	private String itemAge;
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

	// Default Constructor
	public Advertisement() {
		super();
	}

	// parameterized constructor
	public Advertisement(long advertisementId, String advtDescription, String advtCategory, String itemAge,
			Date advtPostDate) {
		super();
		this.advertisementId = advertisementId;
		this.advtDescription = advtDescription;
		this.advtCategory = advtCategory;
		this.itemAge = itemAge;
		this.advtPostDate = advtPostDate;
	}

	// parameterized constructor
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
