package com.backend.business;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.dto.ChefeSubordinado;
import com.backend.entity.ColaboradorEntity;
import com.backend.repositotory.ColaboradorRepository;

@Service
public class ColaboradorBusiness {

	@Autowired
	ColaboradorRepository colaboradorRepository;
	
	@Autowired
	RabbitTemplate rabbitTemplate;
  
	public ColaboradorEntity findById(Integer id) {
		return colaboradorRepository.findById(id).get();
	}

	public List<ColaboradorEntity> findAll() {
		return colaboradorRepository.findAll();

	}

	public ColaboradorEntity save(ColaboradorEntity colaboradorEntity) throws Exception {

		colaboradorEntity = colaboradorRepository.save(colaboradorEntity);
		
		rabbitTemplate.convertAndSend("spring-boot-exchange", "foo.bar.baz", colaboradorEntity.getId());
		
		return colaboradorEntity;
	}
	

	public ColaboradorEntity associaSubordinado(ChefeSubordinado chefeSubordinadoDTO) {
		
		ColaboradorEntity chefe = colaboradorRepository.findById(chefeSubordinadoDTO.getIdChefe()).get();
		ColaboradorEntity subordinado = colaboradorRepository.findById(chefeSubordinadoDTO.getIdSubordinado()).get();
		
		subordinado.setChefe(chefe);
		
		colaboradorRepository.save(subordinado);
		
		return subordinado;
	}


}
