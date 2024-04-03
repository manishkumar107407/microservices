package com.example.order.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.order.utils.JwtUtils;

 

@Component
public class JwtAuthFilter extends AbstractGatewayFilterFactory<JwtAuthFilter.Config>
{
	
	@Autowired
	private RouteValidator routeValidator;
	
	@Autowired
	private RestTemplate restTemplate; 
	
	@Autowired
	private JwtUtils jwtUtils;
	
	public JwtAuthFilter()
	{
	 super(Config.class);	
	}
	

	public static class Config
	{
	}
	
	
	@Override
	public GatewayFilter apply(Config config) {
		 
		return ((exchange,chain)->
		{
		if(routeValidator.predicate.test(exchange.getRequest()))
		{
			if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION))
			{
				throw new RuntimeException("missing AUTHORIZATION header");
			}
			String header=exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
			if(header!=null && header.startsWith("Bearer"))
			{
				header=header.substring(7);	
			}
			try
			{
			jwtUtils.validateToken(header);
			
			//restTemplate.getForObject("http://authServer/validate?token"+header , String.class);	
			}
			
           catch (Exception e) {
		     e.printStackTrace();
		     throw new RuntimeException("Un-AUTHORIZed acees to the application...");
		}			
		}
			
		return chain.filter(exchange);
		});
		
	}
	
}
