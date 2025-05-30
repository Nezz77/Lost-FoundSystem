package lk.ijse.cmjd109.LostandFoundSystem.security.jwt;

import ch.qos.logback.core.util.StringUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.cmjd109.LostandFoundSystem.security.UserDetailServiceIMPL;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
@Component
@RequiredArgsConstructor
@Order(1)
public class AuthFilter extends OncePerRequestFilter {
    private final JWTUtils jwtUtils;
    private final UserDetailServiceIMPL userDetailServiceIMPL;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            //get the token
            var jwToken = getJWToken(request);
            if (jwToken != null && jwtUtils.validateToken(jwToken)) {
               var userName= jwtUtils.getUsernameFromToken(jwToken);
               var userDetails = userDetailServiceIMPL.loadUserByUsername(userName);
               var authToken=
                       new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
               authToken.setDetails(new WebAuthenticationDetails(request));
               SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    private  String getJWToken(HttpServletRequest request) {
        //get auth header
       String authHeader= request.getHeader("Authorization");
       if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")) {
           return authHeader.substring(7);
       }else {
           return null;
       }
    }
}
