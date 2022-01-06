package com.feirasoft.authservice.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Log4j2
@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private static final String JWT_HEADER = "Authorization";
    private static final String JWT_TOKEN_PREFIX = "Bearer ";


    private final UserDetailsService userDetailsService;
    private final JwtProvider jwtProvider;

    private String getJWTFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader(JWT_HEADER);
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith(JWT_TOKEN_PREFIX)) {
            return bearerToken.substring(7);
        }
        return null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = getJWTFromRequest(request); // 1
            if(token != null && !token.isBlank() && jwtProvider.validateToken(token)) { //2
                String username = jwtProvider.getUsername(token); // 3
                log.info("username : {}", username); // 4
                UserDetails user = userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        user, user.getPassword(), user.getAuthorities()
                ); // 5
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); //6
                SecurityContextHolder.getContext().setAuthentication(authenticationToken); //7
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        filterChain.doFilter(request, response);
    }
}
