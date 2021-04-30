package com.teromenat.linguaspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teromenat.linguaspring.entities.CommonSentenceEntity;

@Repository
public interface CommonSentenceRepository extends JpaRepository<CommonSentenceEntity, Long>{
	
}
