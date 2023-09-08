package com.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.business.ColaboradorBusiness;
import com.backend.entity.ColaboradorEntity;

@CrossOrigin(origins = "*")
@RestController
public class ColaboradorController {
	
	/*
	 * 
	 * 
7:37 PM
Lucas Alves
​jovem, uma vez eu fiz colocando uma config no application.yml -> "cors: originPatterns:" e ai coloquei as urls e depois chamei o decorator em cada metodo igual ce fez no controller
	 */
	
	@Autowired
	ColaboradorBusiness colaboradorBusiness;
	
	//@CrossOrigin
    @RequestMapping(method = RequestMethod.POST, path = "/{id}")
	public ColaboradorEntity post(@RequestBody ColaboradorEntity colaboradorEntity) throws Exception {
		return  colaboradorBusiness.save(colaboradorEntity);
	}
	

}
