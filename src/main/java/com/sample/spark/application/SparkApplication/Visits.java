package com.sample.spark.application.SparkApplication;

import java.io.Serializable;

public class Visits implements Serializable {
	private int id;
	private int userId;
	private int venuId;
	private double lat;
	private double longt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getVenuId() {
		return venuId;
	}

	public void setVenuId(int venuId) {
		this.venuId = venuId;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLongt() {
		return longt;
	}

	public void setLongt(double longt) {
		this.longt = longt;
	}

	public Visits(int id, int userId, int venuId, double lat, double longt) {
		super();
		this.id = id;
		this.userId = userId;
		this.venuId = venuId;
		this.lat = lat;
		this.longt = longt;
	}

	public Visits() {
	}

	public static Visits parseData(String str) {
		Visits visits = null;
		str = str.trim();
		try {
			Integer.parseInt(str.split("\\|")[0].trim());
		} catch (Exception e) {
			throw new IllegalArgumentException("User id must be of type int : ");
		}
		visits = new Visits(Integer.parseInt(str.split("\\|")[0].trim()), Integer.parseInt(str.split("\\|")[1].trim()),
				Integer.parseInt(str.split("\\|")[2].trim()), Double.parseDouble(str.split("\\|")[3].trim()),
				Double.parseDouble(str.split("\\|")[4].trim()));
		return visits;
	}

}
