package co.tracert.service;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchElasticTests {

	@Test
	public void givenDirectSearchRequestForWindowEvent_thenResponseIsNotNull() {
		given().when().get("http://localhost:8090/tracert/search/windowevent/first").then()
				.body("hits.total", greaterThan(0)).statusCode(200);
	}

	@Test
	public void givenSearchRequestBySourceIdForWindowEvent_thenResponseIsOK() {
		given().when().get("http://localhost:8090/tracert/windowevent/id/FOhkLmQByi6O4NBFINZ5").then().statusCode(200)
				.body("message", containsString(
						"The operating system started at system time ‎2017‎-‎11‎-‎17T20:21:19.495211900Z."));
	}

}
