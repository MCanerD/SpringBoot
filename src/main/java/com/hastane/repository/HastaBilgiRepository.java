package com.hastane.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.hastane.model.HastaBilgi;

public interface HastaBilgiRepository extends MongoRepository<HastaBilgi, String>{
	
	
}