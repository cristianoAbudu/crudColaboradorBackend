package com.backend.security;

import java.util.Arrays;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backend.entity.ColaboradorEntity;
import com.backend.repositotory.ColaboradorRepository;

@Service
public class UserService implements UserDetailsService {

   private final ColaboradorRepository repository;

   public UserService(ColaboradorRepository repository) {
       this.repository = repository;
   }

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       ColaboradorEntity user = repository.findByNome(username).orElseThrow(() -> new RuntimeException("User not found: " + username));
       GrantedAuthority authority = new SimpleGrantedAuthority("user");
       return new org.springframework.security.core.userdetails.User(user.getNome(), user.getSenha(), Arrays.asList(authority));
   }
}