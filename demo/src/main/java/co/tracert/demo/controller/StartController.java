package co.tracert.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.tracert.demo.model.Profile;

@RestController
@RequestMapping("/demo")
public class StartController {

	@GetMapping("/profile/{profileId}")
	public Profile getProfile() {
		return Profile.getDefault();
	}
}
