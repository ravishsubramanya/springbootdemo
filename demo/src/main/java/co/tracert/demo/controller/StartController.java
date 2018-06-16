package co.tracert.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.tracert.demo.data.repositories.ProfileInfoRepository;
import co.tracert.demo.model.Profile;

@RestController
public class StartController {

	@Autowired
	ProfileInfoRepository repository;

	@GetMapping("/profile/{profileId}")
	public Profile getProfile() {
		List<Profile> result = (List<Profile>) repository.findAll();
		return (result != null && result.size() > 0) ? result.get(0) : null;
	}

	@GetMapping("/profile/all")
	public List<Profile> getAllProfiles() {
		/*
		 * List<Profile> result = (List<Profile>) repository.findAll(); return (result
		 * != null && result.size() > 0) ? result : null;
		 */
		List<Profile> profiles = new ArrayList<Profile>();
		profiles.add(getDummyData());
		return profiles;
	}

	@GetMapping("/")
	public Profile getDummyData() {
		return Profile.getDefault();
	}
}
