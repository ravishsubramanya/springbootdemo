package co.tracert.service.config;

import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import javax.xml.bind.DatatypeConverter;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import groovy.util.NodeBuilder;

@Configuration
@EnableElasticsearchRepositories(basePackages = "co.tracert.service.es.repo")
@ComponentScan(basePackages = { "co.tracert.service.es" })
public class ElasticsearchConfig {

	private static Logger logger = LoggerFactory.getLogger(ElasticsearchConfig.class);

	@Value("${elasticsearch.host}")
	private String EsHost;

	@Value("${elasticsearch.port}")
	private int EsPort;

	@Value("${elasticsearch.clustername}")
	private String EsClusterName;

	@Bean
	public NodeBuilder nodeBuilder() {
		return new NodeBuilder();
	}

	@Bean
	public Client client() throws Exception {
		TransportClient client = null;
		client = new PreBuiltTransportClient(Settings.builder().put("cluster.name", EsClusterName)
				.put("xpack.security.user", "transport_client_user:moonglow").build())
						.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(EsHost), 9200));
		return client;
	}

	public static String encodeBasicHeader(final String username, final String password) {
		return new String(DatatypeConverter.printBase64Binary(
				(username + ":" + Objects.requireNonNull(password)).getBytes(StandardCharsets.UTF_8)));
	}

	@Bean
	public ElasticsearchOperations elasticsearchTemplate() throws Exception {
		return new ElasticsearchTemplate(client());
	}
}
