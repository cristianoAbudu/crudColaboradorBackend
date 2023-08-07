package com.backend.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.dto.ChefeSubordinado;
import com.backend.entity.ColaboradorEntity;
import com.backend.repositotory.ColaboradorRepository;

@Service
public class ColaboradorBusiness {

	@Autowired
	ColaboradorRepository colaboradorRepository;


	public ColaboradorEntity associaSubordinado(ChefeSubordinado chefeSubordinadoDTO) {
		
		ColaboradorEntity subordinado = colaboradorRepository.findById(chefeSubordinadoDTO.getIdSubordinado()).get();

		if(!chefeSubordinadoDTO.getIdChefe().equals(chefeSubordinadoDTO.getIdSubordinado())) {
			ColaboradorEntity chefe = colaboradorRepository.findById(chefeSubordinadoDTO.getIdChefe()).get();
			
			subordinado.setChefe(chefe);
			
			colaboradorRepository.save(subordinado);
			
		}
		
		return subordinado;
	}


}
