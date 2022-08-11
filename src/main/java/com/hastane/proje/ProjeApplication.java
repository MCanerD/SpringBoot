package com.hastane.proje;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@ComponentScan("com.hastane.controller")
@ComponentScan("com.hastane.service")
//yukarıdaki paketleri anlayamadığım bir sebepten kendi görmedi, taramayı bu şekilde yapmam gerekti.(Sebep paketleri app dışında oluşturmuş olmam.)
@ComponentScan(basePackages = {"com.hastane.proje.ProjeApplication"})
@EnableMongoRepositories(basePackages = {"com.hastane.repository"})  //uygulama başlarken repository'i görmeme sorunu çözümü.
@SpringBootApplication
public class ProjeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjeApplication.class, args);
	}

}