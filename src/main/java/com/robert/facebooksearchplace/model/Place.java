package com.robert.facebooksearchplace.model;

public class Place {
	
	private String name;
	private Float latitude;
	private Float longitude;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	
	public Place() {
		super();
	}
	public Place(String name, Float latitude, Float longitude) {
		this();
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	
}
