package com.hastane.config;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

@Configuration
public class MongoConfig {


  private MappingMongoConverter mongoConverter;

  @PostConstruct
  public void setUpMongoEscapeCharacterAndTypeMapperConversion() {
      mongoConverter.setMapKeyDotReplacement("_");
      
      mongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
  }

}