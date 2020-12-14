package com.sds;

public class Branch{
	private String title;
	private char city;
	private double lat;
	private double lng;

	public Branch() {
		super();
	}

	public Branch(String title, char city, double lat, double lng) {
		super();
		this.title = title;
		this.city = city;
		this.lat = lat;
		this.lng = lng;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public char getCity() {
		return city;
	}

	public void setCity(char city) {
		this.city = city;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "Branch [title=" + title + ", city=" + city + ", lat=" + lat + ", lng=" + lng + "]";
	}


}
