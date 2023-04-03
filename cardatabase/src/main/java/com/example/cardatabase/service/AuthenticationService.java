package com.example.cardatabase.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Collections;


public class AuthenticationService {
	static final long EXPIRATIONTIME = 864_000_00;
	static final String SIGNINGKEY = "SecretKey";
	static final String PREFIX = "Bearer";
	
	static public void addToken(HttpServletResponse res, String username){
		String JwtToken = Jwts.builder().setSubject(username).setExpiration(new Date(System.currentTimeMillis()
				+ EXPIRATIONTIME)).signWith(SignatureAlgorithm.HS512, SIGNINGKEY).compact();
		res.addHeader("Authorization", PREFIX + " " + JwtToken);
		res.addHeader("Access-Control-Expose-Headers", "Authorization");
	}
	
	static public Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token != null) {
			String user = Jwts.parser().setSigningKey(SIGNINGKEY)
					.parseClaimsJws(token.replace(PREFIX, ""))
					.getBody()
					.getSubject();
		
		if (user != null)
			return new UsernamePasswordAuthenticationToken(user,null, Collections.emptyList());
		}
		return null;
	}
	
	}
