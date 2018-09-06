package com.asky.backend.config;


import com.asky.backend.model.UserDtoForInsert;
import com.asky.backend.model.UserDtoForLogin;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;



    public JWTAuthenticationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager=authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
       try {
           UserDtoForLogin user = new ObjectMapper()
                   .readValue(request.getInputStream(), UserDtoForLogin.class);
          return  authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword(),new ArrayList<>())
            );
       }catch(IOException e){
           throw new RuntimeException(e);
       }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        String token= Jwts.builder()
                //User class here is User of spring security
                .setSubject(((User)authResult.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512,SecurityConstants.SECRET.getBytes())
                .compact();
        response.addHeader(SecurityConstants.HEADER_STRING,SecurityConstants.TOKEN_PREFIX+token);
    }
}
