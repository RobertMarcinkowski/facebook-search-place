package com.robert.facebooksearchplace.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.Location;
import org.springframework.social.facebook.api.Page;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.stereotype.Service;

import com.robert.facebooksearchplace.model.Place;

@Service
public class FacebookPlace {
	
	@Autowired
    private Facebook facebook;
	
	public List<Place> getPlaces(String country, String city, String place){
		PagedList<Page> facebookList = facebook.pageOperations().search(place);
		List<Place> placeList = new ArrayList<>();
		for (Page page : facebookList) {
			Page pageWithLocation = facebook.fetchObject(page.getId(),Page.class, "location");
			Location location = pageWithLocation.getLocation();
			if (location != null && location.getCountry() != null && location.getCity() != null && country.trim().toUpperCase().equals(location.getCountry().trim().toUpperCase()) && city.trim().toUpperCase().equals(location.getCity().trim().toUpperCase())) {
				String name = page.getName();
				Float latitude = new Float(location.getLatitude());
				Float longitude = new Float(location.getLongitude());
				Place pagePlace = new Place(name,latitude,longitude);
				placeList.add(pagePlace);
			}
		}
		return placeList;
	}
}
