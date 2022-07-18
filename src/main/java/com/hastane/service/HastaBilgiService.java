package com.hastane.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.hastane.model.HastaBilgi;
import com.hastane.repository.HastaBilgiRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HastaBilgiService {
	
	private final HastaBilgiRepository hastaBilgiRepository;
	
	public List<HastaBilgi> getHastaBilgi() {
		return hastaBilgiRepository.findAll();
	}

	public HastaBilgi createHastaBilgi(HastaBilgi newHastaBilgi) {
		return hastaBilgiRepository.save(newHastaBilgi); 
	}

	public void deleteHastaBilgi(String id) {
		hastaBilgiRepository.deleteById(id);
	}

	public void updateHastaBilgi(String id, HastaBilgi newHastaBilgi) {
		
		HastaBilgi oldHastaBilgi = hastaBilgiById(id);
		oldHastaBilgi.setTc(newHastaBilgi.getTc());
		oldHastaBilgi.setHastaAd(newHastaBilgi.getHastaAd());
		oldHastaBilgi.setHastaSoyad(newHastaBilgi.getHastaSoyad());
		oldHastaBilgi.setHastaYas(newHastaBilgi.getHastaYas());
		oldHastaBilgi.setHastaSikayeti(newHastaBilgi.getHastaSikayeti());
		oldHastaBilgi.setTani(newHastaBilgi.getTani());
		oldHastaBilgi.setYatacakMi(newHastaBilgi.getYatacakMi());
		
		hastaBilgiRepository.save(oldHastaBilgi);
	}
	
	public HastaBilgi hastaBilgiById(String id) {
		
//		Optional<HastaBilgi>ById = hastaBilgiRepository.findById(id);
//		if(ById.isEmpty()) {
//			throw new RuntimeException("Böyle bir kayıt bulunmamaktadır.");
//		}
//		return ById.get();
//		Bu yazım şekli ile daha fazla uğraş gereltiriyor ve kodun kısa okunulabilirliğini azaltıyor.
		
		return hastaBilgiRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Böyle bir kayıt bulunmamaktadır."));
	}

	
	
}