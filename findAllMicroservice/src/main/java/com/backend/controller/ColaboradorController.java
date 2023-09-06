package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.business.ColaboradorBusiness;
import com.backend.entity.ColaboradorEntity;

@RestController
public class ColaboradorController {
	
	@Autowired
	ColaboradorBusiness colaboradorBusiness;
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping
	public List<ColaboradorEntity> get(Authentication authentication) {
		return colaboradorBusiness.findAll();
	}

}
