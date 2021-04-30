package com.teromenat.linguaspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teromenat.linguaspring.entities.CommonSentenceEntity;
import com.teromenat.linguaspring.services.CommonSentenceService;

@RestController
@RequestMapping("sentences") // http://localhost:8080/sentences
public class CommonSentenceController {
	
	@Autowired
	CommonSentenceService comSenService;
	
	@GetMapping
	public List<CommonSentenceEntity> getAllSentences() {
		return comSenService.getCommonSentences();
	}

}
