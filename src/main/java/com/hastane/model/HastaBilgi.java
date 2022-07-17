package com.hastane.model;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor        //Boş constructor oluşturur.
@AllArgsConstructor       //Tüm değerleri barındıran constructor oluşturur
@Document(collection = "HastaBilgileri")
public class HastaBilgi {
	@Id
	private String id;
	
	private Long tc;
	private String hastaAd;
	private String hastaSoyad;
	private int hastaYas;
	
	private String hastaSikayeti;
	private String tani;
	
	private Boolean yatacakMi;
	
	private Date createDate = new Date();

}