package com.teromenat.linguaspring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="common_sentences")
public class CommonSentenceEntity implements Serializable {

	private static final long serialVersionUID = 4826806252854174682L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private int languageKey;
	
	@Column(nullable=false)
	private String sentence;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getLanguageKey() {
		return languageKey;
	}

	public void setLanguageKey(int languageKey) {
		this.languageKey = languageKey;
	}

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	
}
