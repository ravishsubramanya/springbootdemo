package co.tracert.service.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.ScoreSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import co.tracert.service.model.Profile;
import co.tracert.service.model.Source;
import co.tracert.service.model.WindowEvent;

@RestController
public class StartController {

	private static Logger logger = LoggerFactory.getLogger(StartController.class);

	@Value("${ELASTIC_PASSWORD}")
	private String elasticPwd;

	@GetMapping("/profile/all")
	public List<Profile> getAllProfiles() {
		List<Profile> profiles = new ArrayList<Profile>();
		profiles.add(Profile.getDefault());
		return profiles;
	}

	@GetMapping("/windowevent/using-rest/first")
	public WindowEvent first() {
		String resourceUrl = "http://localhost:9200/winlogbeat*/_search?size=1&q=*:*";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("elastic", elasticPwd));
		return restTemplate.exchange(resourceUrl, HttpMethod.GET, null, WindowEvent.class).getBody();
	}

	@GetMapping("/windowevent/using-getrequest/id/{doc_id}")
	public Source findEventByDocIdUsingGetRequest(@PathVariable("doc_id") String doc_id) {

		logger.info("doc id to search - " + doc_id);
		RestHighLevelClient client = null;
		Source source = null;

		try {
			final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
			credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("elastic", elasticPwd));

			RestClientBuilder builder = RestClient.builder(new HttpHost("localhost", 9200, "http"))
					.setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
						@Override
						public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
							return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
						}
					});

			client = new RestHighLevelClient(builder);
			GetRequest request = new GetRequest("winlogbeat-6.3.0-2017.11.17", "doc", doc_id);
			if (client.exists(request)) {
				Gson gson = new Gson();
				GetResponse response = client.get(request);
				logger.info(response.getSourceAsString());
				source = gson.fromJson(response.getSourceAsString(), Source.class);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return source;
	}

	@GetMapping("/windowevent/using-searchrequest/id/{doc_id}")
	public Source findEventByDocIdUsingSearchRequest(@PathVariable("doc_id") String doc_id) {

		logger.info("doc id to search - " + doc_id);
		RestHighLevelClient client = null;
		Source source = null;

		try {
			final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
			credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("elastic", elasticPwd));

			RestClientBuilder builder = RestClient.builder(new HttpHost("localhost", 9200, "http"))
					.setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
						@Override
						public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
							return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
						}
					});

			client = new RestHighLevelClient(builder);

			QueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("_id", doc_id);
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			searchSourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC));
			searchSourceBuilder.query(matchQueryBuilder);

			SearchRequest searchRequest = new SearchRequest("winlogbeat-6.3.0-2017.11.17");
			searchRequest.source(searchSourceBuilder);

			Gson gson = new Gson();
			SearchResponse searchResponse = client.search(searchRequest);

			SearchHit[] results = searchResponse.getHits().getHits();
			for (SearchHit hit : results) {
				source = gson.fromJson(hit.getSourceAsString(), Source.class);
				logger.info("response status - " + searchResponse.status().getStatus());
				logger.info("response time - " + searchResponse.getTook());
				logger.info("response total shards - " + searchResponse.getTotalShards());
				logger.info("response success shards - " + searchResponse.getSuccessfulShards());
				logger.info("response failed shards - " + searchResponse.getFailedShards());
				logger.info("response total hits - " + searchResponse.getHits().getTotalHits());
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return source;
	}

}
