package com.sample.spark.application.SparkApplication;

import java.io.Serializable;

public class SocialGraph implements Serializable {
	private int firstUserId;
	private int secondUserId;

	public SocialGraph() {
		super();
	}

	public SocialGraph(int firstUserId, int secondUserId) {
		super();
		this.firstUserId = firstUserId;
		this.secondUserId = secondUserId;
	}

	public int getFirstUserId() {
		return firstUserId;
	}

	public void setFirstUserId(int firstUserId) {
		this.firstUserId = firstUserId;
	}

	public int getSecondUserId() {
		return secondUserId;
	}

	public void setSecondUserId(int secondUserId) {
		this.secondUserId = secondUserId;
	}

	public static SocialGraph parseData(String str) {
		SocialGraph socialGraph = null;
		str = str.trim();
		try {
			Integer.parseInt(str.split("\\|")[0].trim());
		} catch (Exception e) {
			throw new IllegalArgumentException("User id must be of type int : ");
		}
		socialGraph = new SocialGraph(Integer.parseInt(str.split("\\|")[0].trim()),
				Integer.parseInt(str.split("\\|")[0].trim()));
		return socialGraph;
	}
}
