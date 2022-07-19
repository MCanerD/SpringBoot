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

	// post için oluşturulan servis.
	public HastaBilgi createHastaBilgi(HastaBilgi newHastaBilgi) {
		return hastaBilgiRepository.save(newHastaBilgi);
	}

	// get için oluşturulan servis
	public List<HastaBilgi> getHastaBilgi() {
		return hastaBilgiRepository.findAll();
	}

	// delete için oluşturulan servis.
	public void deleteHastaBilgi(String id) {
		hastaBilgiRepository.deleteById(id);
	}

	// put için oluşturulan servis.
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

	// id ile kayıt almak için oluşturulan alan.
	//id sadece 1 tane olduğundan liste olarak oluşturma gereği yok.
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
	
	// tc ile kayıtları almak için servis alanı.
	//Bir hastanın birden fazla kaydı olabileceğinden liste olması gerekli.
	public List<HastaBilgi> getHastaBilgiByTc(Long tc) {
		if(tc == null) {
			return null;
		}
		return hastaBilgiRepository.findByTc(tc);
	}

}