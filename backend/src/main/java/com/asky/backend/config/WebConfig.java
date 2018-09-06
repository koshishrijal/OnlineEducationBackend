package com.asky.backend.config;


import com.asky.backend.service.security.AppUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;

@Configurable
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AppUserDetailService appUserDetailService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(SecurityConstants.SIGN_UP_URL,SecurityConstants.TEST_URL).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                // this disables session creation on Spring Security
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(appUserDetailService).passwordEncoder(passwordEncoder());
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }


    @Bean
    CorsConfigurationSource corsConfigurationSource()
    {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
     //   configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");
        configuration.addExposedHeader(HttpHeaders.AUTHORIZATION);

      //  configuration.setAllowedHeaders(Arrays.asList(HttpHeaders.AUTHORIZATION,HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN,HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,HttpHeaders.ACCESS_CONTROL_REQUEST_HEADERS,HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD));
      // configuration.addAllowedHeader(HttpHeaders.AUTHORIZATION);
    //    configuration.setExposedHeaders(Arrays.asList(HttpHeaders.AUTHORIZATION,HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN,HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,HttpHeaders.ACCESS_CONTROL_REQUEST_HEADERS,HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD));
      // configuration.addExposedHeader(HttpHeaders.AUTHORIZATION);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


}

