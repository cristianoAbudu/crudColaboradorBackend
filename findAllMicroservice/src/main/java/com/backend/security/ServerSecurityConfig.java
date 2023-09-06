package com.backend.security;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

@Configuration
@EnableWebSecurity
public class ServerSecurityConfig  {

   private final UserDetailsService userDetailsService;

   public ServerSecurityConfig(
		   @Qualifier("userService")
           UserDetailsService userDetailsService) {
       this.userDetailsService = userDetailsService;
   }
   
   @Bean
   JwtAuthenticationConverter jwtAuthenticationConverter() {
       JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
       grantedAuthoritiesConverter.setAuthoritiesClaimName("authorities");
       grantedAuthoritiesConverter.setAuthorityPrefix("");

       JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
       jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
       return jwtAuthenticationConverter;
   }

}