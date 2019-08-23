package com.dictionary.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

	
	@Document
public class Dictionary {

	    @Id
	    private String id;

	    public String word;
	    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	    public List<String> meaning;
	    
	    

	    public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getWord() {
	        return word;
	    }

	    public void setWord(String word) {
	        this.word = word;
	    }

	    public List<String> getMeaning() {
	        return meaning;
	    }

	    public void setMeaning(List<String> meaning) {
	        this.meaning = meaning;
	    }



}
