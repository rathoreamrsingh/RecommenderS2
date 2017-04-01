package com.sample.spark.application.SparkApplication;

import java.io.Serializable;

public class UserData implements Serializable {
	private int id;
	private double lat;
	private double logt;

	public UserData() {

	}

	public UserData(int id, double lat, double logt) {
		this.id = id;
		this.lat = lat;
		this.logt = logt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLogt() {
		return logt;
	}

	public void setLogt(double logt) {
		this.logt = logt;
	}

	public static UserData parseData(String str) {
		UserData usr = null;
		str = str.trim();
		try {
			Integer.parseInt(str.split("\\|")[0].trim());
		} catch (Exception e) {
			throw new IllegalArgumentException("User id must be of type int : ");
		}
		usr = new UserData(Integer.parseInt(str.split("\\|")[0].trim()), Double.parseDouble(str.split("\\|")[1].trim()),
				Double.parseDouble(str.split("\\|")[2].trim()));
		return usr;
	}

}
