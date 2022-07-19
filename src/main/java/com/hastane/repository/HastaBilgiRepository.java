package com.hastane.repository;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hastane.model.HastaBilgi;

public interface HastaBilgiRepository extends MongoRepository<HastaBilgi, String>{

	List<HastaBilgi> findByTc(Long tc);
	
	
}