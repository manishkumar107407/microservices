package com.example.order.utils;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils 
{
	
private static final String SECRET = "2A462D4A614E645267556B58703272357538782F413F4428472B4B6250655368";

Map<String, Object> claims =new HashMap<String, Object>();
 
private Key getSignKey() 
{
	byte[] keybytes=Decoders.BASE64.decode(SECRET) ; 
	return Keys.hmacShaKeyFor(keybytes);
}

 
public void validateToken(String token) 
{    
Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
}


 
}
