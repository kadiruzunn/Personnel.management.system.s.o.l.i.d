package com.pms.erp.model.concretes;

import java.time.LocalDate;

public class Kisi {
	
	private int id;
	protected String ad;
	protected String soyad;
	private LocalDate dogumTarihi;
	private String tcKimlikNo;
	
	public Kisi() {
		// TODO Auto-generated constructor stub
	}
	
	public Kisi(int id, String ad, String soyad, LocalDate dogumTarihi, String tcKimlikNo) {
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.dogumTarihi = dogumTarihi;
		this.tcKimlikNo = tcKimlikNo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	public LocalDate getDogumTarihi() {
		return dogumTarihi;
	}
	public void setDogumTarihi(LocalDate dogumTarihi) {
		this.dogumTarihi = dogumTarihi;
	}
	public String getTcKimlikNo() {
		return tcKimlikNo;
	}
	public void setTcKimlikNo(String tcKimlikNo) {
		this.tcKimlikNo = tcKimlikNo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s %s %s", tcKimlikNo, ad, soyad); 
	}
	
	
	public String getAdSoyad() {
		return ad + " " + soyad;
	}
	
	public int getYas() {
		return LocalDate.now().getYear() - dogumTarihi.getYear();
	}

}
