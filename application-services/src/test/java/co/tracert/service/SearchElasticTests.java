package co.tracert.service;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchElasticTests {

	@Test
	public void givenDirectSearchRequestForWindowEvent_thenResponseCodeIs200() {
		given().when().get("http://localhost:8090/tracert/search/windowevent/first").then().statusCode(200);
	}

	@Test
	public void givenDirectSearchRequestForWindowEvent_thenResponseIsNotNull() {
		given().when().get("http://localhost:8090/tracert/search/windowevent/first").then()
				.body("hits/total", contains("Srikanth")).statusCode(200);
	}
}
