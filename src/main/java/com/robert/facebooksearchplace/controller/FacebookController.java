package com.robert.facebooksearchplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.robert.facebooksearchplace.model.Place;
import com.robert.facebooksearchplace.service.FacebookPlace;

@Controller
public class FacebookController {
	
	@Autowired
    private FacebookPlace facebookPlace;

    @Autowired
    private ConnectionRepository connectionRepository;
	
	@RequestMapping("{country}/{city}/{place}")
	@ResponseBody
	public List<Place> searchPlace(@PathVariable String country, @PathVariable String city, @PathVariable String place){
		List<Place> placeList = facebookPlace.getPlaces(country, city, place);
		return placeList;
	}
	
	@GetMapping("/login")
	public String searchPlaces(){
		if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }
		return "/connect/facebookConnected";
	}
	
}
