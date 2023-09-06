package com.backend.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backend.entity.ColaboradorEntity;
import com.backend.repositotory.ColaboradorRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<ColaboradorEntity> colaboradorEntity = colaboradorRepository.findByNome(username);
		
		return new com.backend.security.UserDetails();
	}
	

}
