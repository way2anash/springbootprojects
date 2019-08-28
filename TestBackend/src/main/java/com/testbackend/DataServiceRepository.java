package com.testbackend;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataServiceRepository extends JpaRepository<DataService, Long> {

	

	DataService findByData(String data);

	

}
