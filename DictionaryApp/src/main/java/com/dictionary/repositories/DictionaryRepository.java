package com.dictionary.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.dictionary.models.Dictionary;

public interface DictionaryRepository extends PagingAndSortingRepository<Dictionary, String>{

    Dictionary findByWord(String word);
}
