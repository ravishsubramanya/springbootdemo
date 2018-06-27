package co.tracert.service.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import co.tracert.service.model.Profile;
import co.tracert.service.model.WindowEvent;

@RestController
public class StartController {

	@Value("${ELASTIC_PASSWORD}")
	private String elasticPwd;

	@GetMapping("/profile/all")
	public List<Profile> getAllProfiles() {
		List<Profile> profiles = new ArrayList<Profile>();
		profiles.add(Profile.getDefault());
		return profiles;
	}

	@GetMapping("/search/windowevent/first")
	public WindowEvent first() {
		String resourceUrl = "http://localhost:9200/winlogbeat*/_search?size=1&q=*:*";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("elastic", elasticPwd));
		return restTemplate.exchange(resourceUrl, HttpMethod.GET, null, WindowEvent.class).getBody();
	}

}
