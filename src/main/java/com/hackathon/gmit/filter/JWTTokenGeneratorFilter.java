package com.hackathon.gmit.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.gmit.config.SecurityConfigContraint;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class JWTTokenGeneratorFilter extends OncePerRequestFilter {
	private final String ISSUER = "GMIT system";
	private final String SUBJECT = "JWT Token";
	private final String USERNAME = "username";
	private final String PASSWORD = "password";
	private final int EXPIRATION = 3000;

	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (Objects.nonNull(authentication)) {
			SecretKey key = Keys.hmacShaKeyFor(SecurityConfigContraint.JWT_KEY.getBytes(StandardCharsets.UTF_8));
			String jwt = Jwts.builder().setIssuer(ISSUER).setSubject(SUBJECT)
						.claim(USERNAME, authentication.getName())
					  .claim(PASSWORD, populateAuthorities(authentication.getAuthorities()))
					  .setIssuedAt(new Date())
					.setExpiration(new Date((new Date()).getTime() + EXPIRATION))
					.signWith(key).compact();
			response.setHeader("token", jwt);
			response.setHeader("expiration", String.valueOf(EXPIRATION));
		}

		chain.doFilter(request, response);
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
		return !request.getServletPath().equals("/user/token");
	}
	
	private String populateAuthorities(Collection<? extends GrantedAuthority> collection) {
		Set<String> authoritiesSet = new HashSet<>();
        for (GrantedAuthority authority : collection) {
        	authoritiesSet.add(authority.getAuthority());
        }
        return String.join(",", authoritiesSet);
	}
}
