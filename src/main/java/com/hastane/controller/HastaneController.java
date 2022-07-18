package com.hastane.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/hastane")
@AllArgsConstructor
public class HastaneController {

	public final HastaBilgiService hastaBilgiService;

	@GetMapping("HastaBilgi")
	public ResponseEntity<List<HastaBilgi>> getHastaBilgiler() {
		return new ResponseEntity<>(hastaBilgiService.getHastaBilgi(), HttpStatus.OK);
	}

	@GetMapping("HastaBilgi/{id}")
	public ResponseEntity<HastaBilgi> getHastaBilgi(@PathVariable String id) {
		return new ResponseEntity<>(hastaBilgiById(id), HttpStatus.OK);
	}


	@PostMapping("HastaBilgiEkle")
	public ResponseEntity<HastaBilgi> createHastaBilgi(@RequestBody HastaBilgi newHastaBilgi) {
		return new ResponseEntity<>(hastaBilgiService.createHastaBilgi(newHastaBilgi),HttpStatus.CREATED);
	}

	@PutMapping("HastaBilgiDuzenle/{id}")
	public ResponseEntity<HastaBilgi> getHastaBilgi(@PathVariable String id, @RequestBody HastaBilgi newHastaBilgi) {
		HastaBilgi eskiHastaBilgi = hastaBilgiById(id);
		eskiHastaBilgi.setHastaAd(newHastaBilgi.getHastaAd());
		eskiHastaBilgi.setHastaSoyad(newHastaBilgi.getHastaSoyad());
		eskiHastaBilgi.setHastaYas(newHastaBilgi.getHastaYas());
		eskiHastaBilgi.setHastaSikayeti(newHastaBilgi.getHastaSikayeti());
		eskiHastaBilgi.setTani(newHastaBilgi.getTani());
		eskiHastaBilgi.setYatacakMi(newHastaBilgi.getYatacakMi());

		hastaBilgiService.updateHastaBilgi(id,newHastaBilgi);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("HastaBilgiSil/{id}")
	public ResponseEntity<Void> deleteHastaBilgi(@PathVariable String id) {

		hastaBilgiService.deleteHastaBilgi(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	private HastaBilgi hastaBilgiById(String id) {
		return hastaBilgiService.hastaBilgiById(id);
	}

}