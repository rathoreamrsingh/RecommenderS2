package com.sample.spark.application.SparkApplication;

import java.io.Serializable;

public class Venues implements Serializable {
	private int venuId;
	private double lat;
	private double longt;

	public Venues() {

	}

	public Venues(int venuId, double lat, double longt) {
		this.venuId = venuId;
		this.lat = lat;
		this.longt = longt;
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

	public static Venues parseData(String str) {
		Venues venues = null;
		str = str.trim();
		try {
			Integer.parseInt(str.split("\\|")[0].trim());
		} catch (Exception e) {
			throw new IllegalArgumentException("Venue id must be of type int : ");
		}
		venues = new Venues(Integer.parseInt(str.split("\\|")[0].trim()),
				Double.parseDouble(str.split("\\|")[1].trim()), Double.parseDouble(str.split("\\|")[2].trim()));
		return venues;
	}

}
