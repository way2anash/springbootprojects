package com.dictionary.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dictionary.models.Dictionary;
import com.dictionary.repositories.DictionaryRepository;

@Service
public class DictionaryService {

    public List<Dictionary> dictionary;

    @Autowired
    DictionaryRepository dictionaryRepository;

    public List<String> search(String word) {

        Dictionary d = dictionaryRepository.findByWord(word);
        return d==null?null:d.getMeaning();
    }


    public void add(Dictionary dictionaryWord) {
        dictionaryRepository.save(dictionaryWord);
    }


	
	
	public Iterable<Dictionary> save(List<Dictionary> dictionary) {
        return dictionaryRepository.saveAll(dictionary);
    }
}

