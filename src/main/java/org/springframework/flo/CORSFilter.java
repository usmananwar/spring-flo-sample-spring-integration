package org.springframework.flo;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORSFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse httpServletResponse,
			FilterChain filterChain) throws ServletException, IOException {

		System.out.println("Request URI is: " + req.getRequestURI());

		httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
		httpServletResponse.setHeader("Access-Control-Allow-Methods", "*");
		httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
		httpServletResponse.setHeader("Access-Control-Allow-Headers", "*");

		filterChain.doFilter(req, httpServletResponse);
		System.out.println("Response Status Code is: " + httpServletResponse.getStatus());
	}
}