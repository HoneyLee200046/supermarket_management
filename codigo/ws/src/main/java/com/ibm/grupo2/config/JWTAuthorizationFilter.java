package com.ibm.grupo2.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author Ana Olvera
 */
public class JWTAuthorizationFilter extends OncePerRequestFilter{
    
    private final String HEADER = "Authorization";
    private final String PREFIX = "Bearer ";
    private final String SECRET = "mySecretKey";

    @Override
    protected void doFilterInternal(HttpServletRequest hsr, HttpServletResponse hsr1, FilterChain fc) throws ServletException, IOException {
        try {
            if (existeJWTToken(hsr, hsr1)) {
                Claims claims = validateToken(hsr);
                if (claims.get("authorities") != null) {
                    setUpSpringAuthentication(claims);
                } else {
                    SecurityContextHolder.clearContext();
                }
            }
            fc.doFilter(hsr, hsr1);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
            hsr1.setStatus(HttpServletResponse.SC_FORBIDDEN);
            ((HttpServletResponse) hsr1).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        }
    }
    
    private boolean existeJWTToken(HttpServletRequest request, HttpServletResponse res) {
        String authenticationHeader = request.getHeader(HEADER);
        if (authenticationHeader == null || !authenticationHeader.startsWith(PREFIX)) {
            return false;
        }
        return true;
    }

    private Claims validateToken(HttpServletRequest request) {
        String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
        return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();
    }

    /**
     * Metodo para autenticarnos dentro del flujo de Spring
     *
     * @param claims
     */
    private void setUpSpringAuthentication(Claims claims) {
        List<String> authorities;
        List<SimpleGrantedAuthority> grantedAuthorities;
        authorities = (List) claims.get("authorities");
        grantedAuthorities = authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());

        UsernamePasswordAuthenticationToken auth;
        auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,grantedAuthorities);
        SecurityContextHolder.getContext().setAuthentication(auth);

    }

}
