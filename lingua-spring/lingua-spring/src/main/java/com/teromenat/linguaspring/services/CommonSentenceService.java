package com.teromenat.linguaspring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teromenat.linguaspring.entities.CommonSentenceEntity;
import com.teromenat.linguaspring.repositories.CommonSentenceRepository;

@Service
public class CommonSentenceService {

	@Autowired
	CommonSentenceRepository repository;
	
	public List<CommonSentenceEntity> getCommonSentences() {
		return repository.findAll();
	}
}
