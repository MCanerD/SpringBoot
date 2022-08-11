package com.hastane.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hastane.model.HastaBilgi;
import com.hastane.service.HastaBilgiService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:8080/", allowedHeaders = "*")
@RequestMapping("/hastane")
@AllArgsConstructor
public class HastaneController {

	public final HastaBilgiService hastaBilgiService;

	//Tüm kayıtları alma.
	@GetMapping("HastaBilgi")
	public ResponseEntity<List<HastaBilgi>> getHastaBilgiler() {
		return new ResponseEntity<>(hastaBilgiService.getHastaBilgi(), HttpStatus.OK);
	}

	//Seçilen id'li bilgileri alma.
	@GetMapping("HastaBilgi/{id}")
	public ResponseEntity<HastaBilgi> getHastaBilgi(@PathVariable String id) {
		return new ResponseEntity<>(hastaBilgiById(id), HttpStatus.OK);
	}
	//Kimlik no ile uyuşan kayıtları alma.
	@GetMapping("HastaBilgiTc/{tc}")
	public ResponseEntity<List<HastaBilgi>> getHastaBilgi(@PathVariable Long tc) {
		return new ResponseEntity<>(hastaBilgiService.getHastaBilgiByTc(tc), HttpStatus.OK);
	}

	//Yeni kayıt oluşturma.
	@PostMapping("HastaBilgiEkle")
	public ResponseEntity<HastaBilgi> createHastaBilgi(@RequestBody HastaBilgi newHastaBilgi) {
		return new ResponseEntity<>(hastaBilgiService.createHastaBilgi(newHastaBilgi),HttpStatus.CREATED);
	}
	//Kayıt güncelleme/değiştirme.
	@PutMapping("HastaBilgiDuzenle/{id}")
	public ResponseEntity<HastaBilgi> getHastaBilgi(@PathVariable String id, @RequestBody HastaBilgi newHastaBilgi) {

		hastaBilgiService.updateHastaBilgi(id,newHastaBilgi);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	//Kayıt silme.
	@DeleteMapping("HastaBilgiSil/{id}")
	public ResponseEntity<Void> deleteHastaBilgi(@PathVariable String id) {

		hastaBilgiService.deleteHastaBilgi(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	private HastaBilgi hastaBilgiById(String id) {
		return hastaBilgiService.hastaBilgiById(id);
	}

}