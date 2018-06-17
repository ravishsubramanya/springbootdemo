package co.tracert.service.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.actuate.health.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.tracert.service.model.Profile;

@RestController
public class StartController {

	@GetMapping("/profile/all")
	public List<Profile> getAllProfiles() {
		List<Profile> profiles = new ArrayList<Profile>();
		profiles.add(getDummyData());
		return profiles;
	}

	@GetMapping("/")
	public Profile getDummyData() {
		return Profile.getDefault();
	}

	@GetMapping("/health")
	public Status health() {
		return Status.UP;
	}

}
