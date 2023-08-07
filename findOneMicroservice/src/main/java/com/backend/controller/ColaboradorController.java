package com.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.backend.business.ColaboradorBusiness;
import com.backend.entity.ColaboradorEntity;

@RestController(value = "/colaborador")
public class ColaboradorController {
	
	@Autowired
	ColaboradorBusiness colaboradorBusiness;
	
	@GetMapping("/{id}")
	public ColaboradorEntity get(@PathVariable Integer id) {
		return colaboradorBusiness.findById(id);
	}
	

}
