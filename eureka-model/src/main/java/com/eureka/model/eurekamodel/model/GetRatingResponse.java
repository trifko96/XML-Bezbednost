package com.eureka.model.eurekamodel.model;

import java.util.List;

public class GetRatingResponse {

	private List<Rating> ratings;
	private SoapStatus status;
	
	public GetRatingResponse() {
		
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public SoapStatus getStatus() {
		return status;
	}

	public void setStatus(SoapStatus status) {
		this.status = status;
	}
	
	
}
