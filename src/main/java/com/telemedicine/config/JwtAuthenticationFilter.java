package com.telemedicine.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final JwtService jwtService;
  private final UserDetailsService userDetailsService;

  @Override
  protected void doFilterInternal(
      @NonNull HttpServletRequest request,
      @NonNull HttpServletResponse response,
      @NonNull FilterChain filterChain
  ) throws ServletException, IOException {
    ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request);
    ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(response);

    try {



      log.info("Request: {} {} from {}", request.getMethod(), request.getRequestURI(), request.getRemoteAddr());

      if (request.getServletPath().contains("/api/v1/auth")) {
        filterChain.doFilter(request, response);
        return;
      }
      final String authHeader = request.getHeader("Authorization");
      final String jwt;
      final String userEmail;
      if (authHeader == null || !authHeader.startsWith("Bearer ")) {
        filterChain.doFilter(request, response);
        return;
      }
      jwt = authHeader.substring(7);
      userEmail = jwtService.extractUsername(jwt);
      if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
        if (jwtService.isTokenValid(jwt, userDetails)) {
          UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                  userDetails,
                  null,
                  userDetails.getAuthorities()
          );
          authToken.setDetails(
                  new WebAuthenticationDetailsSource().buildDetails(request)
          );
          SecurityContextHolder.getContext().setAuthentication(authToken);
        }
      }
      filterChain.doFilter(request, response);
    }
    catch (Exception e){
      log.info("exception caught {}", e.getMessage());
    }
    finally {


      String requestBody = new String(wrappedRequest.getContentAsByteArray(), StandardCharsets.UTF_8);
      //log.info("Request Payload: {}", requestBody);

      // Log the response payload
      String responseBody = new String(wrappedResponse.getContentAsByteArray(), StandardCharsets.UTF_8);
      //log.info("Response Payload: {}", responseBody);

      wrappedResponse.copyBodyToResponse();
      // Log the response details
      log.info("Response: {} {}", response.getStatus(), response.getContentType());
    }
  }

}
