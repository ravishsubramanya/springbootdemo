package com.example.springbootzuulgatwayproxy.filters;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class RouteFilter extends ZuulFilter {
	Logger logger = LoggerFactory.getLogger(RouteFilter.class);

	@Override
	public String filterType() {
		return "route";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {

		HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
		logger.info("RESPONSE:: > HTTP:" + response.getStatus());
		return null;
	}
}