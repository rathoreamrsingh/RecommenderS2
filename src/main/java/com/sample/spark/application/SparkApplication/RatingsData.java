package com.sample.spark.application.SparkApplication;

public class RatingsData {
	private int userId;
	private int venueId;
	private int rating;

	public RatingsData() {

	}

	public RatingsData(int userId, int venueId, int rating) {
		super();
		this.userId = userId;
		this.venueId = venueId;
		this.rating = rating;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getVenueId() {
		return venueId;
	}

	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public static RatingsData parseData(String str) {
		RatingsData ratings = null;
		str = str.trim();
		try {
			Integer.parseInt(str.split("\\|")[0].trim());
		} catch (Exception e) {
			throw new IllegalArgumentException("User id must be of type int : ");
		}
		ratings = new RatingsData(Integer.parseInt(str.split("\\|")[0].trim()),
				Integer.parseInt(str.split("\\|")[1].trim()), Integer.parseInt(str.split("\\|")[2].trim()));
		return ratings;
	}
}
