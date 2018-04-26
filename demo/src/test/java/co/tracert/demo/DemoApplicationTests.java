package co.tracert.demo;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;

import co.tracert.demo.data.repositories.ProfileInfoRepository;
import co.tracert.demo.model.Profile;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration
@ActiveProfiles("local")
@TestPropertySource(properties = { "amazon.dynamodb.endpoint=http://localhost:8000/", "amazon.aws.accesskey=key",
		"amazon.aws.secretkey=key2" })
public class DemoApplicationTests {

	private DynamoDBMapper dynamoDBMapper;

	@Autowired
	private AmazonDynamoDB amazonDynamoDB;

	@Autowired
	ProfileInfoRepository repository;

	private static final String EXPECTED_NAME = "Srikanth";

	@Before
	public void setup() throws Exception {
		dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

		DeleteTableRequest deleteTableRequest = dynamoDBMapper.generateDeleteTableRequest(Profile.class);
		amazonDynamoDB.deleteTable(deleteTableRequest);

		CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(Profile.class);
		tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
		amazonDynamoDB.createTable(tableRequest);

		dynamoDBMapper.batchDelete((List<Profile>) repository.findAll());
	}

	@Test
	public void sampleTestCase() {
		repository.save(Profile.getDefault());

		List<Profile> result = (List<Profile>) repository.findAll();

		assertTrue("Not empty", result.size() > 0);
		assertTrue("Contains item with expected NAME", result.get(0).getFirstName().equals(EXPECTED_NAME));
	}
}
