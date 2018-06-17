package co.tracert.apigateway;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootZuulgatewayproxyApplicationTests {

	@Test
	public void givenRequestForProfile_thenResponseCodeIs200() {
		given().when().get("http://localhost:8080/api/tracert/profile/all").then().statusCode(200);
	}

	@Test
	public void givenRequestForProfile_thenResponseContainsSrikanth() {
		given().when().get("http://localhost:8080/api/tracert/profile/all").then()
				.body("firstName", contains("Srikanth")).body("lastName", contains("Kotekar")).statusCode(200);
	}

}
