package com.revature.filters;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class SimpleFilter extends ZuulFilter {

	/*
	 * There are different types of filters that can be triggered
	 * 
	 * 	- "pre": Filter that is executed before the request is redirected
	 * 	- "route": Filter that actually handles the routing of the request
	 * 	- "post": Filter that is executed after the request is redirected
	 * 	- "error": Filter that will execute if an error occurs
	 */
	
	// There are a few methods that you must override to create a filter
	
	
	// This method defines whether the filter is enabled
	@Override
	public boolean shouldFilter() {
		return true;
	}
	
	// This method actually defines the filter logic
	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest req = ctx.getRequest();
		System.out.println("There are no request....Only Zuul!");
		System.out.println(String.format("%s request to url: %s", req.getMethod(), req.getRequestURL().toString()));
		return null;
	}
	
	// This method defines the filter type, as listed above
	@Override
	public String filterType() {
		return "pre";
	}
	
	// This determines the order in which filters will execute
	@Override
	public int filterOrder() {
		return 1;
	}
}
