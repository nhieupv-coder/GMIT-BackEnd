/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.filter;

import com.hackathon.gmit.config.SecurityConfigContraint;
import com.hackathon.gmit.exeption.JWTInvalidException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
@Slf4j
public class JWTTokenValidatorFilter extends OncePerRequestFilter {

	
	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String jwtHeader = request.getHeader(SecurityConfigContraint.JWT_HEADER);
		if (null != jwtHeader) {
			String jwt = jwtHeader.substring(jwtHeader.indexOf(" "));
			try {
				SecretKey key = Keys.hmacShaKeyFor(
						SecurityConfigContraint.JWT_KEY.getBytes(StandardCharsets.UTF_8));
				
				Claims claims = Jwts.parserBuilder()
						.setSigningKey(key)
						.build()
						.parseClaimsJws(jwt)
						.getBody();
				String username = String.valueOf(claims.get("username"));
				String authorities = (String) claims.get("authorities");
				Authentication auth = new UsernamePasswordAuthenticationToken(username,null,
						AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
				SecurityContextHolder.getContext().setAuthentication(auth);
			}catch (Exception e) {
				log.info("Invalid JWT");
			}
			
		}
		chain.doFilter(request, response);
	}

	
	  @Override protected boolean shouldNotFilter(HttpServletRequest request) {
	  return request.getServletPath().equals("/user/token"); }
	 
	
}
