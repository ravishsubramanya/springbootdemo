package co.tracert.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import co.tracert.apigateway.filters.ErrorFilter;
import co.tracert.apigateway.filters.PostFilter;
import co.tracert.apigateway.filters.PreFilter;
import co.tracert.apigateway.filters.RouteFilter;

@SpringBootApplication
@EnableZuulProxy
public class SpringBootZuulgatewayproxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootZuulgatewayproxyApplication.class, args);
	}

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
}
