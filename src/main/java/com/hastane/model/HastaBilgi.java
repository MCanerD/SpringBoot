package com.hastane.model;


import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
	@NotNull
	//@Min(value = 10000000000)
	//@Max(value = 99999999999)
	private Long tc;
	@NotNull
	private String hastaAd;
	@NotNull
	private String hastaSoyad;
	@NotNull
	@Min(value = 0)
	@Max(value = 200)
	private int hastaYas;
	@NotNull
	private String hastaSikayeti;
	@NotNull
	private String tani;
	@NotNull
	private Boolean yatacakMi;
	
	private Date createDate = new Date();

}