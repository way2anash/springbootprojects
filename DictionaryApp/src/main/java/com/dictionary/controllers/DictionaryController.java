package com.dictionary.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dictionary.models.Dictionary;
import com.dictionary.services.DictionaryService;


	
	@RestController
	public class DictionaryController {

	    @Autowired
	    public DictionaryService dictionaryService;

	    @GetMapping("/search/{word}")
	    public List<String> searchMeaning(@PathVariable String word){
	        return dictionaryService.search(word);
	    }

	    @PostMapping(value = "/add")
	    public void addWordAndMeaning(@RequestBody Dictionary dictionaryWord){
	        dictionaryService.add(dictionaryWord);
	    }
	    
	    
	    
	}


