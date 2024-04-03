	package com.example.order.filter;
	
	import java.util.*;
	import java.util.function.Predicate;
	
	import org.springframework.http.server.reactive.ServerHttpRequest;
	 
	import org.springframework.stereotype.Component;
	
	@Component
	public class RouteValidator 
	{
		
	public static final List<String> listApi=List.of(
			"/auth/register",
			"/auth/token",
			"/auth/validate"
			);
	
	public Predicate<ServerHttpRequest> predicate= 
	
	        request -> listApi
	                    .stream()
	                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
	
	}
