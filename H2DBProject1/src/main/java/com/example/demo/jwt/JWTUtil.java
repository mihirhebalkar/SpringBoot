package com.example.demo.jwt;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class JWTUtil {
	private String secret = "mySecretKey";
	private long expiration = 8640000;
	
	public String generateToken(String username) {
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}
	
	public String extractUsername(String token) {
		return Jwts.parser().setSigningKey(secret)
				.parseClaimsJws(token).getBody().getSubject();
	}
}
