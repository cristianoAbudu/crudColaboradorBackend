package com.backend.business;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import com.backend.dto.ChefeSubordinado;
import com.backend.entity.ColaboradorEntity;
import com.backend.repositotory.ColaboradorRepository;
import com.backend.util.SenhaUtil;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

@Service
public class ColaboradorBusiness {

	@Autowired
	ColaboradorRepository colaboradorRepository;

	public ColaboradorEntity findById(Integer id) {
		return colaboradorRepository.findById(id).get();
	}

	public List<ColaboradorEntity> findAll() {
		return colaboradorRepository.findAll();

	}

	public ColaboradorEntity save(ColaboradorEntity colaboradorEntity) throws Exception {

		colaboradorEntity.setScore(SenhaUtil.calculaComplexidade(colaboradorEntity.getSenha()));
		
		colaboradorEntity.setSenha(SenhaUtil.encryptPassword(colaboradorEntity.getSenha()));

		return colaboradorRepository.save(colaboradorEntity);
	}
	

	public ColaboradorEntity associaSubordinado(ChefeSubordinado chefeSubordinadoDTO) {
		
		ColaboradorEntity chefe = colaboradorRepository.findById(chefeSubordinadoDTO.getIdChefe()).get();
		ColaboradorEntity subordinado = colaboradorRepository.findById(chefeSubordinadoDTO.getIdSubordinado()).get();
		
		subordinado.setChefe(chefe);
		
		colaboradorRepository.save(subordinado);
		
		return subordinado;
	}


}
